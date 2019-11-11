package com.revature.html;

import com.revature.json.models.Element;
import com.revature.json.models.Feature;
import com.revature.json.models.Result;
import com.revature.json.models.Step;

public class Generator {
	private static final String NEWLINE = System.lineSeparator();

	private static boolean doesPass(Element element) {
		if (element == null) {
			return false;
		}
		boolean passes = true;
		if (element.getSteps() == null) {
			return false;
		}
		for (Step step : element.getSteps()) {
			passes = passes && Generator.doesPass(step);
		}
		return passes;
	}

	private static boolean doesPass(Feature feature) {
		if (feature == null) {
			return false;
		}
		boolean passes = true;
		if (feature.getElements() == null) {
			return false;
		}
		for (Element elem : feature.getElements()) {
			passes = passes && Generator.doesPass(elem);
		}

		return passes;
	}

	private static boolean doesPass(Step step) {
		if (step == null) {
			return false;
		}
		Result res = step.getResult();
		if (res == null) {
			return false;
		}
		String status = res.getStatus();
		if (status == null) {
			return false;
		}
		return status.equals("passed");
	}

	private static String generateContents(Feature[] features) {
		String results = "<h1>Overall Results</h1>" + Generator.NEWLINE;
		if (features == null) {
			return results;
		}
		results += Generator.generateSummaryTable(features);

		results += "<h1>Features</h1>" + Generator.NEWLINE;
		for (Feature feature : features) {
			results += Generator.generateTable(feature);
		}

		for (Feature feature : features) {
			results += Generator.generateTable(feature);
			if (feature.getElements() == null) {
				continue;
			}
			results += "<h1>Scenarios for feature '" + feature.getName()
				+ "'</h1>" + Generator.NEWLINE;
			for (Element element : feature.getElements()) {
				results += Generator.generateTable(element);
			}
		}

		return results;
	}

	private static String generateSummaryTable(Feature[] features) {
		String results = "<table class=\"table\">" + Generator.NEWLINE
			+ "<thead>" + Generator.NEWLINE + "<tr>" + Generator.NEWLINE
			+ "<th>Feature</th>" + Generator.NEWLINE + "<th>Status</th>"
			+ Generator.NEWLINE + "</tr>" + Generator.NEWLINE + "</thead>"
			+ Generator.NEWLINE;

		results += "<tbody>" + Generator.NEWLINE;

		if (features != null) {
			for (Feature feature : features) {
				results += "<tr>" + Generator.NEWLINE;
				results +=
					"<td>" + feature.getName() + "</td>" + Generator.NEWLINE;
				results += "<td>";
				if (Generator.doesPass(feature)) {
					results += "passed";
				}
				else {
					results += "failed";
				}
				results += "</td>" + Generator.NEWLINE;
				results += "</tr>" + Generator.NEWLINE;
			}
		}

		results +=
			"</tbody>" + Generator.NEWLINE + "</table>" + Generator.NEWLINE;

		return results;
	}

	/**
	 * Generate a table with header for an element of a feature, such as a
	 * scenario or scenario outline.
	 *
	 * @param element The element to create a table for.
	 * @return The HTML table with title.
	 */
	private static String generateTable(Element element) {
		if (element == null) {
			return "";
		}
		String results = "<h2>" + Generator.NEWLINE + element.getKeyword()
			+ ": " + element.getName() + "</h2>" + Generator.NEWLINE;

		// table headers
		results += "<table class=\"table\">" + Generator.NEWLINE + "<thead>"
			+ Generator.NEWLINE + "<tr>" + Generator.NEWLINE + "<th>Type</th>"
			+ Generator.NEWLINE + "<th>Name</th>" + Generator.NEWLINE
			+ "<th>Result</th>" + Generator.NEWLINE + "</tr>"
			+ Generator.NEWLINE + "</thead>" + Generator.NEWLINE;

		results += "<tbody>" + Generator.NEWLINE;

		// Step names and results
		if (element.getSteps() != null) {
			for (Step step : element.getSteps()) {
				results += "<tr>" + Generator.NEWLINE;
				results +=
					"<td>" + step.getKeyword() + "</td>" + Generator.NEWLINE;
				results +=
					"<td>" + step.getName() + "</td>" + Generator.NEWLINE;
				results += "<td>" + step.getResult().getStatus() + "</td>"
					+ Generator.NEWLINE;
				results += "</tr>" + Generator.NEWLINE;
			}
		}

		results +=
			"</tbody>" + Generator.NEWLINE + "</table>" + Generator.NEWLINE;

		return results;
	}

	/**
	 * Generate a table summarizing the elements of a feature, with a title
	 * above.
	 *
	 * @param feature The feature to generate a table for.
	 * @return The HTML for a title and summary table.
	 */
	private static String generateTable(Feature feature) {
		if (feature == null) {
			return "";
		}
		String results = "<h2>" + Generator.NEWLINE + feature.getKeyword()
			+ ": " + feature.getName() + "</h2>" + Generator.NEWLINE;

		results += "<table class=\"table\">" + Generator.NEWLINE + "<thead>"
			+ Generator.NEWLINE + "<tr>" + Generator.NEWLINE + "<th>Type</th>"
			+ Generator.NEWLINE + "<th>Name</th>" + Generator.NEWLINE
			+ "<th>Result</th>" + Generator.NEWLINE + "</tr>"
			+ Generator.NEWLINE + "</thead>" + Generator.NEWLINE;

		results += "<tbody>" + Generator.NEWLINE;

		if (feature.getElements() != null) {
			for (Element element : feature.getElements()) {
				results += "<tr>" + Generator.NEWLINE;
				results +=
					"<td>" + element.getKeyword() + "</td>" + Generator.NEWLINE;
				results +=
					"<td>" + element.getName() + "</td>" + Generator.NEWLINE;
				results += "<td>";
				if (Generator.doesPass(element)) {
					results += "passed";
				}
				else {
					results += "failed";
				}
				results += "</td>" + Generator.NEWLINE;
				results += "</tr>" + Generator.NEWLINE;
			}
		}

		results +=
			"</tbody>" + Generator.NEWLINE + "</table>" + Generator.NEWLINE;
		return results;
	}

	private static String getFooter() {
		return "<script src=\"/bootstrap.min.js\">" + Generator.NEWLINE
			+ "</body>" + Generator.NEWLINE + "</html>";
	}

	private static String getHeader() {
		return "<html>" + Generator.NEWLINE + "<head>" + Generator.NEWLINE
			+ "<title>Caliber 2 Test Results</title>" + Generator.NEWLINE
			+ "<link rel=\"stylesheet\" href=\"/bootstrap.min.css\">"
			+ Generator.NEWLINE + "</head>" + Generator.NEWLINE + "<body>"
			+ Generator.NEWLINE;
	}

	public static String toWebPage(Feature[] features) {
		return Generator.getHeader() + Generator.generateContents(features)
			+ Generator.getFooter();
	}
}
