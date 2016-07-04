package com.garrytrue.cleanarhitecturegitapi.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tiv on 30.06.2016.
 */
public class TestUtils {
    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    public void log(String log) {
        System.out.println(log);
    }

    public Gson getGson() {
        return gson;
    }


    public <T> T readJson(String fileName, Class<T> inClass) {
        return gson.fromJson(readString(fileName), inClass);
    }

    public String readString(String fileName) {
        log(fileName);
        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
        log(stream.toString());
        try {
            int size = stream.available();
            byte[] buffer = new byte[size];
            int result = stream.read(buffer);
            return new String(buffer, "utf8");
        } catch (IOException e) {
            log(e.getLocalizedMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
