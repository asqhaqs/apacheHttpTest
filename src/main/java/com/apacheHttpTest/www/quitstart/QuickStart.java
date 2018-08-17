package com.apacheHttpTest.www.quitstart;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xudong on 2018/8/17.
 */
public class QuickStart {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try{
            HttpGet httpGet = new HttpGet("http://httpbin.org/get");
            CloseableHttpResponse response = httpClient.execute(httpGet);

            try{
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                EntityUtils.consume(entity);
            }finally {
                response.close();
            }

            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("username","vip"));
            nvps.add(new BasicNameValuePair("password","secret"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpClient.execute(httpPost);

            try{
                System.out.println(response2.getStatusLine());
                HttpEntity entity1 = response2.getEntity();
                EntityUtils.consume(entity1);
            }finally {
                response2.close();
            }

        }finally {
            httpClient.close();
        }
    }
}
