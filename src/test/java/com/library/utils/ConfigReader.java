package com.library.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


    private static Properties prop;

    private static InputStream input = null;

    static {
        try {
            input = new FileInputStream("configuration.properties");
            prop = new Properties();
            prop.load(input);

            input.close();
        } catch (IOException ex) {
            System.out.println("ConfigurationReader class error... check it !!!");
        }
    }

    public static String getProperty(String property){
        return prop.getProperty(property);
    }


}
