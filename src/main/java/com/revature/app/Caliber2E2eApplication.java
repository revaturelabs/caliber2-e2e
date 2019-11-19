package com.revature.app;

import com.revature.html.Generator;
import com.revature.json.models.Feature;
import com.revature.runner.ChromeRunner;
import com.revature.utils.Config;
import gherkin.deps.com.google.gson.Gson;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Caliber2E2eApplication {

	/**
	 * I know. Abnormal termination.
	 */
	private static final int PASSED = 1;
	private static final int FAILED = 0;

	/**
	 * Exports a resource from the jar into the folder we are running from.
	 *
	 * @param resourceName The name of the resource without a leading slash.
	 * @throws Exception If a problem occurs.
	 */
	public static void exportResource(String resourceName) throws Exception {
		InputStream stream = null;
		OutputStream resStreamOut = null;
		try {
			stream = Caliber2E2eApplication.class
				.getResourceAsStream("/" + resourceName);
			if (stream == null) {
				throw new Exception("Cannot get resource \"" + resourceName
					+ "\" from Jar file.");
			}

			int readBytes;
			byte[] buffer = new byte[4096];

			File toCreate = new File(resourceName);

			toCreate.createNewFile();

			resStreamOut = new FileOutputStream(toCreate);
			while ((readBytes = stream.read(buffer)) > 0) {
				resStreamOut.write(buffer, 0, readBytes);
			}
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			if (stream != null) {
				stream.close();
			}
			if (resStreamOut != null) {
				resStreamOut.close();
			}
		}
	}

	public static void main(String[] args) {
		// SpringApplication.run(Caliber2E2eApplication.class, args);

		String htmlFilename = "results.html";

		if (args == null || args.length == 0) {
			System.err.println("Please specify a url in the arguments.");
			Caliber2E2eApplication.printHelp();
			return;
		}

		if (args[0].toLowerCase().matches("[-]{1,2}h(elp)?")) {
			Caliber2E2eApplication.printHelp();
			return;
		}

		if (args.length > 1) {
			if (args[1].toLowerCase().matches("-(-)?h(tml-output)?")) {
				if (args.length < 3) {
					System.err.println("Missing filename for html output.");
					Caliber2E2eApplication.printHelp();
					return;
				}
				if (args[2] == null || args[2].isEmpty()) {
					System.err.println("Filename for HTML output is empty.");
					Caliber2E2eApplication.printHelp();
					return;
				}
				htmlFilename = args[2];
			}
			else {
				System.err.println("Unknown argument '" + args[1] + "'");
				Caliber2E2eApplication.printHelp();
				return;
			}
		}

		Config.setURL(args[0]);

		// Run the junit tests
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(ChromeRunner.class);

		// parse the json output
		Gson gson = new Gson();
		FileReader cucumber = null;
		try {
			/*
			 * The runtime/execution path and jar path should be the same
			 * directory. That is, the 'java -jar' command should be run from
			 * the directory the jar is in.
			 */
			File cucumberFile = new File("cucumber.json");
			cucumber = new FileReader(cucumberFile);
		}
		catch (Exception e) {
			e.printStackTrace();
			// I am sorry
			try {
				if (cucumber != null) {
					cucumber.close();
				}
			}
			catch (IOException e2) {
				e2.printStackTrace();
			}
			return;
		}

		// Actually parse into objects
		Feature[] parsed = gson.fromJson(cucumber, Feature[].class);

		// generate html
		String webPage = Generator.toWebPage(parsed);
		File output = new File(htmlFilename);
		FileWriter writer = null;
		try {
			writer = new FileWriter(output);
			writer.append(webPage);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (writer != null) {
					writer.close();
				}
			}
			catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		if (Generator.doesPass(parsed)) {
			System.exit(Caliber2E2eApplication.PASSED);
		}
		else {
			System.exit(Caliber2E2eApplication.FAILED);
		}

	}

	/**
	 * Print out usage info for the jar.
	 */
	private static void printHelp() {
		System.out.println(
			"Usage: java -jar <jar name> [--help] <url> [--html-output <filename>]");
		System.out.println();
		System.out.println(
			"    jar name : The name of the jar, such as 'caliber2-e2e-0.0.1-SNAPSHOT.jar'");
		System.out.println(
			"    url      : The url of the web-app home page, such as 'http://example.com/caliber/vp/home'");
		System.out.println();
		System.out.println(
			"If '--help' is specified, will print this and not run anything.");
		System.out.println(
			"The '--html-output' flag is for specifying the name of the html file to");
		System.out.println("    output results to, such as 'results.html'.");
		System.out.println();
	}
}
