package com.ms.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

	private Properties prop;

	private static Utility INSTANCE;

	private Utility() {

	}

	private void initProperties() throws IOException {

		if (prop == null) {
			InputStream inputStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("monitoring.properties");
			prop = new Properties();
			if (inputStream != null) {

				prop.load(inputStream);
			} else {
				throw new FileNotFoundException();
			}
		}
	}

	public String getPropertyValueForKey(String key) throws IOException {
		// get the property value and print it out
		initProperties();
		String value = prop.getProperty(key);

		return value;
	}

	public static Utility getInstance() {

		if (INSTANCE == null) {
			synchronized (Utility.class) {
				if (INSTANCE == null) {
					INSTANCE = new Utility();
				}
			}
		}

		return INSTANCE;
	}

}

/**
 * nakuls
 */