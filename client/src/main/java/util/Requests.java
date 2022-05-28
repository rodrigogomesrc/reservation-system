package util;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.UnsupportedEncodingException;

import static org.apache.http.client.utils.URLEncodedUtils.CONTENT_TYPE;
import static org.apache.http.impl.client.HttpClients.createDefault;

public class Requests {
    public static final String ENDPOINT = "http://127.0.0.1:8080" ;

    public static String postString(String context, String data) throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = createDefault();
        HttpPost httpPost = new HttpPost(ENDPOINT + context);
        httpPost.setHeader(CONTENT_TYPE, "application/json");
        httpPost.setEntity(new StringEntity(data));
        CloseableHttpResponse response = null;
        String responseString = "";
        try {
            response = httpClient.execute(httpPost);
            responseString = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return responseString;
    }

    public static String getString(String context) {
        CloseableHttpClient httpClient = createDefault();
        HttpGet httpGet = new HttpGet(ENDPOINT + context);
        RequestConfig requestConfig = RequestConfig.custom()
          .setCookieSpec(CookieSpecs.STANDARD)
          .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        String responseString = "";
        try {
            response = httpClient.execute(httpGet);
            responseString = response.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return responseString;
    }
}


