package com.xyc.guokhttps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 * Created by hasee on 2017/12/25.
 */

public class PreferencesUtils {

    public static String PREFERENCE_NAME = "TrineaAndroidCommon";

    public static boolean putString(String key, String value) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getString(String key) {
        Context context = ApplicationHolder.getAppContext();
        return getString(key, null);
    }

    public static String getString( String key, String defaultValue) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        return settings.getString(key, defaultValue);
    }

    public static boolean putInt(String key, int value) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static int getInt( String key) {
        return getInt(key, -1);
    }

    public static int getInt(String key, int defaultValue) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        return settings.getInt(key, defaultValue);
    }

    public static boolean putLong(String key, long value) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static long getLong(String key) {
        return getLong(key, -1L);
    }

    public static long getLong( String key, long defaultValue) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        return settings.getLong(key, defaultValue);
    }

    public static boolean putBoolean(String key, boolean value) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public static boolean getBoolean( String key, boolean defaultValue) {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        return settings.getBoolean(key, defaultValue);
    }

    public static void clearshare() {
        Context context = ApplicationHolder.getAppContext();
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE_NAME, 0);
        Editor editor = settings.edit();
        editor.clear();
        editor.apply();
    }
}
