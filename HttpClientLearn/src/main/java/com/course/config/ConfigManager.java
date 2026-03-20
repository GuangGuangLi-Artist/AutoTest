package com.course.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties props = new Properties();

    static {
        try(InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {

        if(input == null) {
            throw new RuntimeException("Unable to find config.properties");

        }
        props.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
