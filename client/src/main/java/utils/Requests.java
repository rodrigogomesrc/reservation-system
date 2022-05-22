package utils;

import model.DTO.ClientDataDTO;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.UnsupportedEncodingException;


public class Requests {

    public static final String ENDPOINT = "http://127.0.0.1:8080/" ;

    public static void postString(String context, String data){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(ENDPOINT);
        request.setConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build());
        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        StringEntity entity = null;
        try {
            entity = new StringEntity(data);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String responseString;
        ClientDataDTO teste = new ClientDataDTO(123,"teste");

        try {
            request.setEntity(entity);
            //HttpResponse response = client.execute(request);
            //responseString = EntityUtils.toString(response.getEntity());
            CloseableHttpResponse response = client.execute(request);
            client.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
