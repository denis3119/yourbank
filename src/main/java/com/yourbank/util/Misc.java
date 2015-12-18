package com.yourbank.util;

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
}
