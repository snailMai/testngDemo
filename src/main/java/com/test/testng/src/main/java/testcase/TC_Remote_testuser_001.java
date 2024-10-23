package com.test.testng.src.main.java.testcase;

import com.test.testng.src.main.java.global.GLOBALPARAMETER;
import com.test.testng.utils.HttpConnect;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Remote_testuser_001 {
    public static void main(String[] args) {
        String url = GLOBALPARAMETER.ENCRYPTION;
        String json = "{\"key\":\"1\",\"pwd\":\"2\"}";
        HttpConnect httpConnect = new HttpConnect();
        Response response;
        url = GLOBALPARAMETER.HOST + "/testuser/allTestUserVue/page/1";
        HttpConnect.httpPost(url, json);
    }


    @Test
    public void testPost() {
        String url = GLOBALPARAMETER.ENCRYPTION;
        String json = "{\"key\":\"1\",\"pwd\":\"2\"}";
        HttpConnect httpConnect = new HttpConnect();
//        Response response;
        HttpConnect.httpPost(url, json);
    }

    @Test
    public void testGet() {
        String url = GLOBALPARAMETER.GETTESTUSERBYPAGE.replace("{}", "1");
        HttpConnect httpConnect = new HttpConnect();
//        Response response;
        HttpConnect.httpGet(url);
    }
}
