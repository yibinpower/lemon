package day14;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: YiBin
 * @Description: httpclient的get、post与及json格式化方法封装成工具
 * @Date: Created in 上午 09:50 20/05/15
 * @Modified By:
 */
public class HttpUtils {
    public static void main(String[] args) {
        //测试自定义的get方法
        String url_info = "http://api.lemonban.com/futureloan/member/8882574/info";
        try {
            String prettyEntity = get(url_info);
            System.out.println(prettyEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //测试自定义的post方法
        String url_register = "http://api.lemonban.com/futureloan/member/register";
        String param = "{\"mobile_phone\": \"13012344321\",\"pwd\": \"12345678\"}";
        try {
            String prettyResponse = post(url_register, param);
            System.out.println(prettyResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * http的get请求方法封装
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        HttpGet get = new HttpGet(url);
        get.setHeader("X-Lemonban-Media-Type","lemonban.v1");

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse reponse = client.execute(get);
        HttpEntity entity = reponse.getEntity();
        String strEntity = EntityUtils.toString(entity);
        String prettyEntity = jsonFormat(strEntity);
        return prettyEntity;
    }


    /**
     * http的post请求方法封装
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public static String post(String url,String param) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        httpPost.setHeader("Content-Type","application/json");

        httpPost.setEntity(new StringEntity(param,"utf-8"));
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);
        String strEntity = EntityUtils.toString(response.getEntity());
        String prettyEntity = jsonFormat(strEntity);

        return prettyEntity;
    }


    /**
     * json字符串格式化
     * @param json_str
     * @return
     */
    public static String jsonFormat(String json_str){
        JSONObject object = JSONObject.parseObject(json_str);
        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        return pretty;
    }

}
