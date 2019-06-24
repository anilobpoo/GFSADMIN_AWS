package com.obpoo.gfsfabricsoftware.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPObyCusData;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class PreferenceConnector {

    public static final String PREF_NAME = "GFS_SharedPreferences";
    public static final int MODE = Context.MODE_PRIVATE;

    /**
     * to write integer into prefernce connector
     *
     * @param context context
     * @param key     key
     * @param value   value
     */
    public static void writeBoolean(Context context, String key, boolean value) {
        getEditor(context).putBoolean(key, value).commit();
    }

    /**
     * to read integer into prefernce connector
     *
     * @param context  context
     * @param key      key
     * @param defValue defValue
     */
    public static boolean readBoolean(Context context, String key, boolean defValue) {
        return getPreferences(context).getBoolean(key, defValue);
    }

    /**
     * to write string into prefernce connector
     *
     * @param context context
     * @param key     key
     * @param value   value
     */
    public static void writeString(Context context, String key, String value) {
        getEditor(context).putString(key, value).commit();
    }

    /**
     * to read integer into prefernce connector
     *
     * @param context  context
     * @param key      key
     * @param defValue defValue
     */
    public static String readString(Context context, String key, String defValue) {
        return getPreferences(context).getString(key, defValue);
    }

    /**
     * to write integer into prefernce connector
     *
     * @param context context
     * @param key     key
     * @param value   value
     */
    public static void writeInteger(Context context, String key, int value) {
        getEditor(context).putInt(key, value).commit();
    }

    /**
     * to read integer into prefernce connector
     *
     * @param context  context
     * @param key      key
     * @param defValue defValue
     */
    public static int readInteger(Context context, String key, int defValue) {
        return getPreferences(context).getInt(key, defValue);
    }

    /**
     * to get shared preferences
     *
     * @param context context
     * @return name and mode of shared preferences
     */
    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    /**
     * to get edited value
     *
     * @param context context
     * @return edited shared preference
     */
    public static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    /**
     * to cleasr data in SharedPreferences
     *
     * @param context context
     */
    public static void clearData(Context context) {
        getEditor(context).clear().commit();
    }

    public static void saveArrayList(ArrayList<String> list, String key, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public static ArrayList<String> getArrayList(String key,Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
    public static void saveArraylistofObjects (ArrayList<TrackPObyCusData>list ,String key,Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();

    }
    public static ArrayList<TrackPObyCusData> getArraylistofObject(String key, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<TrackPObyCusData>>(){}.getType();
        return gson.fromJson(json, type);

    }
}
