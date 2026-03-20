package com.course.code.utils;

import com.course.code.domain.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("testcaseconfig", Locale.CHINA);
    private static final String ENV_PROPERTY = "env";
    private static final String ENV_TYPE_PROPERTY = "env.type";
    private static final String DEFAULT_ENV = "test";

    /**
     * 优先从 JVM 系统属性中读取环境类型（env / env.type），没有则使用配置文件中的值。
     */
    private static String getEnvType() {
        String env = System.getProperty(ENV_PROPERTY);
        if (env == null || env.trim().isEmpty()) {
            env = System.getProperty(ENV_TYPE_PROPERTY);
        }
        if (env == null || env.trim().isEmpty()) {
            env = bundle.getString("env");
        }
        return env == null ? DEFAULT_ENV : env.trim().toLowerCase();
    }

    private static String getBaseUrl() {
        String env = getEnvType();
        if ("dev".equalsIgnoreCase(env)) {
            return bundle.getString("dev.url");
        }
        return bundle.getString("test.url");
    }

    private static String getMocoBaseUrl() {
        String env = getEnvType();
        if ("dev".equalsIgnoreCase(env)) {
            return bundle.getString("dev.moco.url");
        }
        return bundle.getString("test.moco.url");
    }

    public static String getUrl(InterfaceName name){
        String address = getBaseUrl();

        String uri="";

        if(name==InterfaceName.ADDUSER){
            uri = bundle.getString("addUser.uri");
        }
        if(name==InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if(name==InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");
        }

        if(name==InterfaceName.UPDATEUSER){
            uri = bundle.getString("updateUser.uri");
        }

        if(name==InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        return address + uri;
    }

    public static String getMocoUrl(InterfaceName name){
        String address = getMocoBaseUrl();
        String uri="";
        if(name==InterfaceName.MOCOLOGIN){
            uri = bundle.getString("moco.login.uri");
        }

        if(name==InterfaceName.MOCOGET){
            uri = bundle.getString("moco.get.uri");
        }

        if(name==InterfaceName.MOCOPOSTURLENCODED){
            uri = bundle.getString("moco.post.uri");
        }

        return address + uri;

    }
}
