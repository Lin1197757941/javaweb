package com.example.store;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {
    public static void main(String[] args){
        try {
            InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            System.out.println(is);
            Properties pros=new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
