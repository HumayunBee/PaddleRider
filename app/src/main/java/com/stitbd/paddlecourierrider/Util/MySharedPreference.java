package com.stitbd.paddlecourierrider.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


public class MySharedPreference {

    private static SharedPreferences sharedPreferences=null;
    private MySharedPreference(){

    }

    public static synchronized SharedPreferences getInstance(Context context){

        if (sharedPreferences==null){
            return sharedPreferences=context.getSharedPreferences(Constant.MY_TOKEN_ID, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static SharedPreferences.Editor editor(Context context){
        if (sharedPreferences != null){
            return sharedPreferences.edit();
        }else {

            Toast.makeText(context, "SharedPreferences Should Not be Null", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    public static void remove(Context context){
        if (sharedPreferences != null){
            sharedPreferences.edit().clear().commit();
        }else {

            Toast.makeText(context, "SharedPreferences Should Not be Null", Toast.LENGTH_SHORT).show();

        }
    }
}
