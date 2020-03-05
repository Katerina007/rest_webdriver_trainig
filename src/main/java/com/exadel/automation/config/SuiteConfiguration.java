package com.exadel.automation.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Loads test suite configuration from resource files.
 */
public class SuiteConfiguration {

    private static final String APPLICATION_PROPERTIES = "/application.properties";

    private Properties properties;

    public SuiteConfiguration() throws IOException {
        this(System.getProperty("application.properties", APPLICATION_PROPERTIES));
    }

    public SuiteConfiguration(String fromResource) throws IOException {
        properties = new Properties();
        properties.load(SuiteConfiguration.class.getResourceAsStream(fromResource));
    }

    public boolean hasProperty(String name) {
        return properties.contains(name);
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}