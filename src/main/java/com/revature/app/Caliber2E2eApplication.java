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

	/**
	 * Print out usage info for the jar.
	 */
	private static void printHelp() {
		System.out.println("Usage: java -jar <jar name> <url>");
		System.out.println();
		System.out.println(
			"    jar name : The name of the jar, such as 'caliber2-e2e-0.0.1-SNAPSHOT.jar'");
		System.out.println(
			"    url      : The url of the web-app home page, such as 'http://example.com/caliber/vp/home'");
		System.out.println();
	}

	public static void main(String[] args) {
		// SpringApplication.run(Caliber2E2eApplication.class, args);

		if (args == null || args.length == 0) {
			System.err.println("Please specify a url in the arguments.");
			printHelp();
		}

		if (args.length > 1) {
			System.out.println(
				"Warning: more than one argument provided, this may be an error.");
			printHelp();
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
		File output = new File("test.html");
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
}
