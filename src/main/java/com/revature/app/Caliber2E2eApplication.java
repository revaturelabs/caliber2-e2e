package com.revature.app;

import com.revature.json.models.Feature;
import com.revature.runner.Caliber2Runner;
import gherkin.deps.com.google.gson.Gson;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class Caliber2E2eApplication {

	public static void main(String[] args) {
		SpringApplication.run(Caliber2E2eApplication.class, args);

		// Run the junit tests
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(Caliber2Runner.class);

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
			System.out.println(cucumberFile.getAbsolutePath());
			cucumber = new FileReader(cucumberFile);
		}
		catch (Exception e) {
			e.printStackTrace();
			// I am sorry
			try {
				cucumber.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
			return;
		}

		// Actually parse into objects
		Feature[] parsed = gson.fromJson(cucumber, Feature[].class);

	}

}
