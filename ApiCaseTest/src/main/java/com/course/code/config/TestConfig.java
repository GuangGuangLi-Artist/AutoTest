package com.course.code.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {

    public static String loginUrl;
    public static String addUserUrl;
    public static String getUserInfoUrl;
    public static String getUserListUrl;
    public static String updateUserUrl;


    public static DefaultHttpClient defaultHttpClient;

    public static CookieStore cookieStore;
}
