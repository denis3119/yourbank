package com.yourbank.util;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by admin on 15.12.2015.
 */
public class Misc {
    /*
    * если хоть один объект null - true;
    * */
    public static boolean isNull(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }

    public long norm(String item, long def) {
        try {
            return Long.parseLong(item);
        } catch (Exception e) {
            return def;
        }
    }

    /*
    если сервер  соеденен с интернетом
    * */
    public static boolean isOnline() {
        boolean result = true;
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL("http://vk.com").openConnection();
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1500);
            connection.connect();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
