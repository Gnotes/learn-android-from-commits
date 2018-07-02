package utils;

import android.util.Log;

public class Logs {

    public static void v(String tag, String msg){
        Log.v(tag,msg);
    }

    public static void d(String tag, String msg){
        Log.d(tag, msg);
    }

}
