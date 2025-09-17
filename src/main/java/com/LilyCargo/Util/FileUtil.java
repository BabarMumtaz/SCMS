package com.LilyCargo.Util;

import java.io.*;
import java.util.Properties;

public class FileUtil {

    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\com\\LilyCargo\\TestData\\fidNumberTest-data.properties";

    // Save a key-value pair
    public static void saveData(String key, String value) {
        try {
            Properties props = new Properties();
            File file = new File(FILE_PATH);

            // Load old data if file already exists
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                props.load(fis);
                fis.close();
            }

            props.setProperty(key, value);

            FileOutputStream fos = new FileOutputStream(file);
            props.store(fos, "Test Data File");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read a value by key
    public static String getData(String key) {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(FILE_PATH);
            props.load(fis);
            fis.close();
            return props.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

/*

Modify your file util to append instead of overwrite:

public static void appendData(String key, String value) {
    try {
        Properties props = new Properties();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
            fis.close();
        }

        String oldValue = props.getProperty(key, "");
        String newValue = oldValue.isEmpty() ? value : oldValue + "," + value;

        props.setProperty(key, newValue);

        FileOutputStream fos = new FileOutputStream(file);
        props.store(fos, "Test Data File");
        fos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
*/
