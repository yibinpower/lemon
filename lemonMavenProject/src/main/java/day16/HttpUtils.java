package day16;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @Author: YiBin
 * @Description: httpclient的get、post、patch请求封装，获取响应封装，json格式化方法封装，以及请求方法调度方法call封装
 * @Date: Created in 上午 09:50 20/05/15
 * @Modified By:
 */
public class HttpUtils {
    public static void main(String[] args) throws IOException {
        //测试call方法
        //用户信息接口验证get
        String body = call("get", "json", "http://api.lemonban.com/futureloan/member/8882574/info", "");
        System.out.println(body);
        System.out.println("=========================================================================");
        //注册接口验证post
        String body2 = call("post", "json", "http://api.lemonban.com/futureloan/member/register", "{\"mobile_phone\": \"13012344321\",\"pwd\": \"12345678\"}");
        System.out.println(body2);


        //测试自定义的get方法
//        String url_info = "http://api.lemonban.com/futureloan/member/8882574/info";
//        try {
//            String prettyEntity = get(url_info);
//            System.out.println(prettyEntity);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //测试自定义的post方法
//        String url_register = "http://api.lemonban.com/futureloan/member/register";
//        String param = "{\"mobile_phone\": \"13012344321\",\"pwd\": \"12345678\"}";
//        try {
//            String prettyResponse = post(url_register, param);
//            System.out.println(prettyResponse);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


    /**
     * 请求的调度方法，根据请求类型（post、get、patch）和参数类型（json、form）来选择具体的请求方法
     * @param type
     * @param contentType
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public static String call(String type, String contentType, String url, String param) {
        String body = "";
        try {
            if ("post".equals(type)){
                if ("json".equals(contentType)){
                    body = post(url,param);
                }else if("form".equals(contentType)){
                    body = formPost(url,param);
                }
            }else if ("get".equals(type)){
                body = get(url);
            }else if ("patch".equals(type)){
                body = patch(url,param);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
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
        CloseableHttpResponse response = client.execute(get);

        getRequest(get);
        return getResponse(response);
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

        getRequest(httpPost);
        return getResponse(response);
    }


    /**
     * http的post请求方法封装
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public static String patch(String url,String param) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        httpPost.setHeader("Content-Type","application/json");

        httpPost.setEntity(new StringEntity(param,"utf-8"));
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        getRequest(httpPost);
        return getResponse(response);
    }


    /**
     * http的form表单post请求方法封装
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public static String formPost(String url,String param) throws IOException {
        HttpPost httpPost = new HttpPost(url);
//        httpPost.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");

        String form = json2KeyValue(param);
        httpPost.setEntity(new StringEntity(form,"utf-8"));
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        getRequest(httpPost);
        return getResponse(response);
    }


    /**
     * json字符串转为key=value的form表单的字符串
     * @param json
     * @return
     */
    public static String json2KeyValue(String json){
        if (StringUtils.isEmpty(json)){
            return "";
        }

        String result = "";
        Map map = JSONObject.parseObject(json, Map.class);
        Set<String> set = map.keySet();
        for (String key : set){
            result += key + "=" + map.get(key) + "&";
        }
        result= result.substring(0, result.length() - 1);

        return result;
    }


    /**
     * 封装响应内容的方法
     * @param response
     * @return
     * @throws IOException
     */
    public static String getResponse(CloseableHttpResponse response) throws IOException {
        //获取响应头
        Header[] allHeaders = response.getAllHeaders();
        //获取响应体
        HttpEntity entity = response.getEntity();
        //获取状态码
        response.getStatusLine().getStatusCode();

//        System.out.println(Arrays.toString(allHeaders));
        String body = EntityUtils.toString(entity);

        //格式化json字符串
        body = jsonFormat(body);
//        System.out.println(body);

        return body;
    }


    /**
     * 获取请求头、体
     * @param httpRequestBase
     */
    public static void getRequest(HttpRequestBase httpRequestBase){
        //请求头
        String headers = Arrays.toString(httpRequestBase.getAllHeaders());
        //请求体
        String requests = httpRequestBase.getRequestLine().toString();
        System.out.println("请求："+headers+"\n"+requests);

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
