package com.course.code.utils;

import com.course.code.domain.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("testcaseconfig", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");

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


        String testUrl = address + uri;

        return testUrl;
    }

    public static String getMocoUrl(InterfaceName name){
        String address = bundle.getString("moco.url");
        String uri="";
        if(name==InterfaceName.MOCOLOGIN){
            uri = bundle.getString("moco.login.uri");
        }

        if(name==InterfaceName.MOCOGET){
            uri = bundle.getString("moco.get.uri");
        }

        String testUrl = address + uri;

        return testUrl;

    }
}
