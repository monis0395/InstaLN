package com.android.kohaku.instaln.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by monis.q on 12-03-2018.
 */

public class InstaUtils {
    public static String urlEncode(String string) {
        try {
            return URLEncoder.encode(string, "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("monis", "urlEncode exception", e);
        }
        return null;
    }
}
