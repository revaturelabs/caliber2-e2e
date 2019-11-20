package com.revature.utils;

/**
 * Global configuration for the application, such as the URL to test.
 */
public class Config {

	private static String url = "";

	/**
	 * The name of the cucumber json output to use. Static for use in the runner
	 * annotation.
	 */
	public static final String CUCUMBER_FILENAME = "cucumber.json";

	/**
	 * Returns the URL to run cucumber tests on.
	 *
	 * @return The URL of the home page for the web application.
	 * @see #isURLSet()
	 */
	public static synchronized String getURL() {
		return Config.url;
	}

	/**
	 * Returns the URL to run cucumber tests on.
	 *
	 * @return The URL of the home page for the web application.
	 * @see #isURLSet()
	 */
	public static synchronized String get() {
		return Config.url;
	}

	/**
	 * Returns false if the URL is null or empty, otherwise returns true. This
	 * indicates the URL has been set but does not validate that the URL is
	 * valid.
	 *
	 * @return True if the URL has been set, false if the URL is empty or null.
	 */
	public static synchronized boolean isURLSet() {
		if (Config.url == null || Config.url.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Set the URL to test using the cucumber tests.
	 *
	 * @param toTest The URL of the home page for the application.
	 * @return True on success, false if toTest is null.
	 */
	public static synchronized boolean setURL(String toTest) {
		if (toTest == null) {
			return false;
		}
		Config.url = toTest;
		return true;
	}

}
