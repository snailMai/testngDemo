package com.test.testng.logic;

import com.test.testng.utils.ReporterLogger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/*
网站:
1. HttpClient使用详解与实战一：普通的GET和POST请求: https://www.cnblogs.com/fnlingnzb-learner/p/10832471.html
2. java+httpclient—— 一个简单的get请求——httpclient单独获取cookie: https://www.cnblogs.com/xiaobaibailongma/p/15084022.html

 */

public class HttpUtils {
    private static final ReporterLogger logger = new ReporterLogger(HttpUtils.class);

    public static HttpResponseVo httpGet(String url){
        HttpResponseVo httpResponseVo = null;
        HttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();

        if (url.contains("?")){
            String[] httpGetUrlArr = url.split("\\?");
            String urlSuffix = httpGetUrlArr[1];
            try {
                URIBuilder uriBuilder = new URIBuilder(httpGetUrlArr[0]);

                // 对每个&,添加查询参数  (else 是没有?)
                if (urlSuffix.contains("&")){
                    String[] parasArr = urlSuffix.split("&");
                    for (int i = 0; i < parasArr.length; i++) {
                        uriBuilder.addParameter(parasArr[i].split("=")[0], parasArr[i].split("=")[1]);
                    }
                }else {
                    uriBuilder.addParameter(urlSuffix.split("=")[0], urlSuffix.split("=")[1]);
                }

                HttpGet httpGet = new HttpGet(uriBuilder.build());
                response = httpClient.execute(httpGet);


            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            try {
                URIBuilder uriBuilder = new URIBuilder(url);
                HttpGet httpGet = new HttpGet(uriBuilder.build());
                try {
                    logger.info("httpGet请求：" + url);
                    response = httpClient.execute(httpGet);
//                    logger.info("httpGet返回码：" + response.getStatusLine().getStatusCode());
//                    HttpEntity entity = response.getEntity();
//                    String bodyResult = EntityUtils.toString(entity, "utf-8");
//                    logger.info("httpGet返回内容：" + bodyResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        // 返回body
        String resultBody = null;
        try {
            resultBody = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回header
        Header[] headerArr = response.getAllHeaders();
        StringBuilder resultHeader = new StringBuilder();
        resultHeader.append("{");
        for (Header header : headerArr){
            resultHeader.append("\"" + header.getName() + "\":\"" + header.getValue() + ",");
        }
        resultHeader.deleteCharAt(resultHeader.lastIndexOf(","));
        resultHeader.append("}");

        // 返回cookie, 先不做  --- 有时间做

        httpResponseVo = new HttpResponseVo(response.getStatusLine().getStatusCode(),
                resultBody,
                null,
                resultHeader.toString()
                );


        return  httpResponseVo;
    }

    public static void main(String[] args) {
        // 以下三行是为了删除多余标注  少了很多日志
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");

        HttpResponse response = null;
        HttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=0&type=all&web_location=333.934&w_rid=313ddb5bd49cf3ef91ce7d5e2bf182e4&wts=1705810091";
//        url = url + "/" + args[0];
//        for (int i = 1; i < args.length; i++) {
//            url += "&" + args[i];
//        }
//        url = "http://129.226.174.57:8081/myBlog/testuser/testng";
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            try {
                logger.info("httpGet请求：" + url);
                response = httpClient.execute(httpGet);
                logger.info("httpGet返回码：" + response.getStatusLine().getStatusCode());
                HttpEntity entity = response.getEntity();
                String bodyResult = EntityUtils.toString(entity, "utf-8");
                logger.info("httpGet返回内容：" + bodyResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
