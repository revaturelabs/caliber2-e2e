package com.revature.html;

import com.revature.json.models.Element;
import com.revature.json.models.Feature;
import com.revature.json.models.Result;
import com.revature.json.models.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Used to convert models of cucumber output json data into the HTML for a web
 * page that summarizes the results. Allows for an overview, drilling down into
 * data to see what is wrong, and collapsing sections to get them out of the
 * way.
 */
public class Generator {
	private static final String NEWLINE = System.lineSeparator();
	private static final String TABLE_CONTAINER =
		"<div class=\"container border rounded p-3 mt-2 bg-white\">";
	private static final String LINK_TO_TOP =
		"<a href=\"#overall_results\">Back to top</a>";
	/**
	 * Used in {@link #linkifyTitle(String, boolean, Object)} for tracking how
	 * much a name has been used.
	 */
	private static Map<String, Integer> linkCounts = new HashMap<>();
	/**
	 * Stores the link text for specific objects so when we want to reference
	 * them in links, we can get the string for that object.
	 */
	private static Map<Object, String> linkStorage = new HashMap<>();

	private static String calculateScenarioTitle(Feature feature) {
		return "Scenarios for feature '" + feature.getName() + "'";
	}

	private static String calculateTitle(Element element) {
		return element.getKeyword() + ": " + element.getName();
	}

	private static String calculateTitle(Feature feature) {
		return feature.getKeyword() + ": " + feature.getName();
	}

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

	/**
	 * Returns true if all the features pass. Each level passes if and only if
	 * all of the components pass. So if all features pass this passes, if any
	 * step fails then the failure cascades up.
	 * 
	 * @param features The list of features.
	 * @return True if all the features pass, false if anything is not passing.
	 */
	public static boolean doesPass(Feature[] features) {
		if (features == null) {
			return false;
		}
		boolean passes = true;

		for (Feature feature : features) {
			passes = passes && Generator.doesPass(feature);
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

	/**
	 * Calculates and returns the string to put in where the features table
	 * goes. This is done late in the process so that links can be correct.
	 * 
	 * @param features The features to create a table for.
	 * @return The HTML to insert in for where the features table is.
	 */
	private static String generateFeaturesTable(Feature[] features) {
		String results = "";
		// generate a collapsable accordion for the features
		results +=
			"<div class=\"accordion border-bottom\" id=\"featuresCollapse\">"
				+ Generator.NEWLINE;
		results += "<div class=\"card\">" + Generator.NEWLINE
			+ "<div class=\"card-header\" id=\"featureHeading\">"
			+ "<button class=\"btn btn-link\" data-toggle=\"collapse\"  data-target=\"#featuresBody\" aria-expanded=\"false\" aria-controls=\"featuresBody\">Hide/Show</button>"
			+ Generator.NEWLINE + "</div>" + Generator.NEWLINE;
		results +=
			"<div id=\"featuresBody\" class=\"collapse show\" aria-labelledby=\"featureHeading\" data-parent=\"#featuresCollapse\">"
				+ Generator.NEWLINE + "<div class=\"card-body\">";
		for (Feature feature : features) {
			// header for the feature
			String title = Generator.calculateTitle(feature);
			results += "<h2 id=\""
				+ Generator.linkifyTitle(title, true, feature) + "\">"
				+ Generator.NEWLINE + title + "</h2>" + Generator.NEWLINE;

			// generate a table inside a div
			results += Generator.TABLE_CONTAINER + Generator.NEWLINE;
			results += Generator.generateTable(feature);
			results += "</div>" + Generator.NEWLINE;
			results += Generator.LINK_TO_TOP + Generator.NEWLINE;
		}
		results += "</div>" + Generator.NEWLINE + "</div>" + Generator.NEWLINE;
		results += "</div>" + Generator.NEWLINE + "</div>" + Generator.NEWLINE;
		return results;
	}

	private static String generateScenarioTables(Feature[] features) {
		String results = "";
		for (Feature feature : features) {
			if (feature.getElements() == null) {
				continue;
			}
			String title = Generator.calculateScenarioTitle(feature);
			results += "<h1 id=\"" + Generator.linkifyTitle(title, true, null)
				+ "\">" + title + "</h1>" + Generator.NEWLINE;

			// we want the name but strip off the pound sign
			String convenientScenarioName =
				Generator.linkifyTitle(title, false, feature).substring(1);

			// construct an accordion with unique ids
			results += "<div class=\"accordion border-bottom\" id=\""
				+ convenientScenarioName + "Collapse\">" + Generator.NEWLINE;
			results += "<div class=\"card\">" + Generator.NEWLINE
				+ "<div class=\"card-header\" id=\"" + convenientScenarioName
				+ "Heading\">"
				+ "<button class=\"btn btn-link\" data-toggle=\"collapse\"  data-target=\"#"
				+ convenientScenarioName
				+ "Body\" aria-expanded=\"false\" aria-controls=\""
				+ convenientScenarioName + "Body\">Hide/Show</button>"
				+ Generator.NEWLINE + "</div>" + Generator.NEWLINE;
			results += "<div id=\"" + convenientScenarioName
				+ "Body\" class=\"collapse show\" aria-labelledby=\""
				+ convenientScenarioName + "Heading\" data-parent=\"#"
				+ convenientScenarioName + "Collapse\">" + Generator.NEWLINE
				+ "<div class=\"card-body\">";

			for (Element element : feature.getElements()) {
				// header for the element
				String subtitle = Generator.calculateTitle(element);
				results += "<h2 id=\""
					+ Generator.linkifyTitle(subtitle, true, element) + "\">"
					+ subtitle + "</h2>" + Generator.NEWLINE;

				// generate a table inside a div
				results += Generator.TABLE_CONTAINER + Generator.NEWLINE;
				results += Generator.generateTable(element);
				results += "</div>" + Generator.NEWLINE;
				results += "<a href=\""
					+ Generator.linkifyTitle(Generator.calculateTitle(feature),
						false, feature)
					+ "\">Back to parent feature '" + feature.getName()
					+ "'</a>" + Generator.NEWLINE;
			}
			results +=
				"</div>" + Generator.NEWLINE + "</div>" + Generator.NEWLINE;
			results +=
				"</div>" + Generator.NEWLINE + "</div>" + Generator.NEWLINE;
		}
		return results;
	}

	private static String generateContents(Feature[] features) {
		// forgive me for this
		String results = "<h1 id=\"overall_results\">Overall Results</h1>"
			+ Generator.NEWLINE;
		if (features == null) {
			return results;
		}

		// generate a table inside a div
		results += Generator.TABLE_CONTAINER + Generator.NEWLINE;
		results += Generator.generateSummaryTable(features);
		results += "</div>" + Generator.NEWLINE;

		results += "<h1 id=\"features\">Features</h1>" + Generator.NEWLINE;

		String scenariosChunk = generateScenarioTables(features);
		// we have to calculate this later so that links have the right value
		String featuresTableChunk = generateFeaturesTable(features);

		// we calculated out of order but they go summary table first
		results += featuresTableChunk;
		results += scenariosChunk;
		return results;
	}

	/**
	 * Generates a summary of features. This lists the status of each feature as
	 * a whole. If any part of the feature is not passing, the feature is
	 * failed. This includes links to the {@link #generateTable(Feature) tables
	 * describing each feature}.
	 * 
	 * @param features The features to generate a table for.
	 * @return The HTML for the table.
	 * @see #generateTable(Feature)
	 */
	private static String generateSummaryTable(Feature[] features) {
		String results =
			"<table class=\"table table-hover\">" + Generator.NEWLINE
				+ "<thead>" + Generator.NEWLINE + "<tr>" + Generator.NEWLINE
				+ "<th scope=\"col\">Feature</th>" + Generator.NEWLINE
				+ "<th scope=\"col\">Status</th>" + Generator.NEWLINE + "</tr>"
				+ Generator.NEWLINE + "</thead>" + Generator.NEWLINE;

		results += "<tbody>" + Generator.NEWLINE;

		if (features != null) {
			for (Feature feature : features) {
				results += "<tr>" + Generator.NEWLINE;
				results += "<td>" + Generator.NEWLINE + "<a href=\""
					+ Generator.linkifyTitle(Generator.calculateTitle(feature),
						false, feature)
					+ "\">" + feature.getName() + "</a>" + Generator.NEWLINE
					+ "</td>" + Generator.NEWLINE;
				if (Generator.doesPass(feature)) {
					results += "<td class=\"table-success\">passed";
				}
				else {
					results += "<td class=\"table-danger\">failed";
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
	 * Generate a table for an element of a feature, such as a scenario or
	 * scenario outline.
	 *
	 * @param element The element to create a table for.
	 * @return The HTML table with title.
	 */
	private static String generateTable(Element element) {
		if (element == null) {
			return "";
		}
		String results =
			"<table class=\"table table-hover\">" + Generator.NEWLINE
				+ "<thead>" + Generator.NEWLINE + "<tr>" + Generator.NEWLINE
				+ "<th scope=\"col\">Type</th>" + Generator.NEWLINE
				+ "<th scope=\"col\">Name</th>" + Generator.NEWLINE
				+ "<th scope=\"col\">Result</th>" + Generator.NEWLINE + "</tr>"
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

				String status = step.getResult().getStatus();
				if (status.equals("passed")) {
					results += "<td class=\"table-success\">";
				}
				else if (status.equals("failed")) {
					results += "<td class=\"table-danger\">";
				}
				else {
					results += "<td class=\"table-warning\">";
				}

				results += Generator.NEWLINE + status + Generator.NEWLINE
					+ "</td>" + Generator.NEWLINE;
				results += "</tr>" + Generator.NEWLINE;
			}
		}

		results +=
			"</tbody>" + Generator.NEWLINE + "</table>" + Generator.NEWLINE;

		return results;
	}

	/**
	 * Generate a table summarizing the elements of a feature. This includes
	 * links to the {@link #generateTable(Element) table summarizing each
	 * element}.
	 *
	 * @param feature The feature to generate a table for.
	 * @return The HTML for a title and summary table.
	 * @see #generateTable(Element)
	 */
	private static String generateTable(Feature feature) {
		if (feature == null) {
			return "";
		}
		String results =
			"<table class=\"table table-hover\">" + Generator.NEWLINE
				+ "<thead>" + Generator.NEWLINE + "<tr>" + Generator.NEWLINE
				+ "<th scope=\"col\">Type</th>" + Generator.NEWLINE
				+ "<th scope=\"col\">Name</th>" + Generator.NEWLINE
				+ "<th scope=\"col\">Result</th>" + Generator.NEWLINE + "</tr>"
				+ Generator.NEWLINE + "</thead>" + Generator.NEWLINE;

		results += "<tbody>" + Generator.NEWLINE;

		if (feature.getElements() != null) {
			for (Element element : feature.getElements()) {
				results += "<tr>" + Generator.NEWLINE;
				results +=
					"<td>" + element.getKeyword() + "</td>" + Generator.NEWLINE;
				results += "<td><a href=\""
					+ Generator.linkifyTitle(Generator.calculateTitle(element),
						false, element)
					+ "\">" + element.getName() + "</a></td>"
					+ Generator.NEWLINE;
				if (Generator.doesPass(element)) {
					results += "<td class=\"table-success\">passed";
				}
				else {
					results += "<td class=\"table-danger\">failed";
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
	 * Returns the HTML for the bottom of the page, closing out the main div,
	 * body, and html.
	 * 
	 * @return The HTML for the bottom of the page.
	 */
	private static String getFooter() {
		return "</div>"
			+ "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>"
			+ Generator.NEWLINE
			+ "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>"
			+ Generator.NEWLINE
			+ "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>"
			+ Generator.NEWLINE + "</body>" + Generator.NEWLINE + "</html>";
	}

	/**
	 * Returns the HTML for the top of the page, including the doctype, header,
	 * css, and opening the main container div.
	 * 
	 * @return The HTML for the top of the document.
	 */
	private static String getHeader() {
		return "<!doctype html>" + Generator.NEWLINE + "<html>"
			+ Generator.NEWLINE + "<head>" + Generator.NEWLINE
			+ "<meta charset=\"utf-8\">" + Generator.NEWLINE
			+ "<title>Caliber 2 Test Results</title>" + Generator.NEWLINE
			+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
			+ Generator.NEWLINE
			+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">"
			+ Generator.NEWLINE + "</head>" + Generator.NEWLINE
			+ "<body class=\"bg-light\">" + Generator.NEWLINE
			+ "<div class=\"container\">";
	}

	/**
	 * Take in a name and turn it into a link format, so remove spaces, etc.
	 * This will also make sure the links are unique.
	 * 
	 * @param name The name of a thing.
	 * @param updateCount If this is a new link, false if we are just looking up
	 *            the most recent.
	 * @param subject The object we are getting a link to. If null, nothing is
	 *            stored.
	 * @return The link or ID it should have.
	 */
	private static String linkifyTitle(String name, boolean updateCount,
		Object subject) {
		if (name == null) {
			return null;
		}

		if (!updateCount) {
			/*
			 * If we are not updating to a new link number, and looking for an
			 * object that already had a link created for it, we can just fetch
			 * the link and return it.
			 */
			if (Generator.linkStorage.containsKey(subject)) {
				// we are linking to an existing id, so prepend a #
				return "#" + Generator.linkStorage.get(subject);
			}
		}
		String cleaned = name.trim().toLowerCase().replaceAll("[^a-z0-9 ]+", "")
			.replaceAll("\\s+", "_");
		/*
		 * We track how many times a link has been used. If it has already been
		 * used one or more times, we start tacking on a number to the links so
		 * we can tell them apart.
		 */
		int newCount = 0;
		if (Generator.linkCounts.containsKey(cleaned)) {
			newCount = Generator.linkCounts.get(cleaned);
			if (updateCount) {
				++newCount;
			}
		}
		if (updateCount) {
			Generator.linkCounts.put(cleaned, newCount);
		}
		String result;

		if (updateCount) {
			// id's already prepend a #
			result = "";
		}
		else {
			// we are linking to an existing thing
			result = "#";
		}
		result += cleaned;
		if (newCount > 0) {
			result += newCount;
		}

		if (updateCount && subject != null) {
			Generator.linkStorage.put(subject, result);
		}
		return result;
	}

	/**
	 * Go through and give things names.
	 *
	 * @param features The features to prettify.
	 */
	private static void prettify(Feature[] features) {
		if (features == null) {
			return;
		}

		// clear out duplicate background steps
		for (Feature feature : features) {
			if (feature.getElements() == null) {
				continue;
			}
			ArrayList<Element> unique = new ArrayList<>();
			ArrayList<String> backgroundNames = new ArrayList<>();
			for (Element element : feature.getElements()) {
				if (element.getKeyword() == null) {
					continue;
				}
				final String keyword = element.getKeyword();
				if (!keyword.equals("Background")) {
					unique.add(element);
					continue;
				}
				if (backgroundNames.contains(keyword)) {
					continue;
				}
				unique.add(element);
				backgroundNames.add(keyword);
			}
			feature.setElements(unique.toArray(new Element[unique.size()]));
		}

		// we go through one layer at a time naming things
		int nextUnnamed = 1;
		for (Feature feature : features) {
			if (feature.getName() == null || feature.getName().isEmpty()) {
				feature.setName("UnnamedFeature" + nextUnnamed);
				++nextUnnamed;
			}
		}

		nextUnnamed = 1;
		for (Feature feature : features) {
			if (feature.getElements() == null) {
				continue;
			}
			for (Element element : feature.getElements()) {
				if (element.getName() == null || element.getName().isEmpty()) {
					element.setName(
						"Unnamed" + element.getKeyword() + nextUnnamed);
					++nextUnnamed;
				}
			}
		}

		nextUnnamed = 1;

		for (Feature feature : features) {
			if (feature.getElements() == null) {
				continue;
			}
			for (Element element : feature.getElements()) {
				if (element.getSteps() == null) {
					continue;
				}
				for (Step step : element.getSteps()) {
					if (step.getName() == null || step.getName().isEmpty()) {
						step.setName(
							"Unnamed" + step.getKeyword().trim() + nextUnnamed);
						++nextUnnamed;
					}
				}
			}
		}
	}

	/**
	 * Take in features and create a web page with them. This will go through
	 * and modify the passed in features to be more pretty, so note that this is
	 * a destructive process.
	 *
	 * @param features The features to pretty up and generate a page for.
	 * @return The contents of an HTML document as a string.
	 */
	public static String toWebPage(Feature[] features) {
		Generator.prettify(features);
		return Generator.getHeader() + Generator.generateContents(features)
			+ Generator.getFooter();
	}
}
