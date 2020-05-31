package day13;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: YiBin
 * @Description:
 * @Date: Created in 下午 02:28 20/05/12
 * @Modified By:
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException {
        final String base_url = "http://api.lemonban.com/futureloan";
        String mobile_phone = "13555554322";
        String pwd = "12345678";

        /*
            1、先完成用户注册
         */
        String url = "/member/register";
        //初始化一个post请求
        HttpPost httpPost = new HttpPost(base_url+url);
        //设置头信息
        httpPost.setHeader("X-Lemonban-Media-Type","lemonban.v1");
        httpPost.setHeader("Content-Type","application/json");
        //添加参数，通过JSONObject对象来添加参数，最后转为json字符串；把参数分解成字符串其目的是为了后面的请求可以方便使用自定义参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mobile_phone",mobile_phone);
        jsonObject.put("pwd",pwd);
        String param = jsonObject.toJSONString();

        httpPost.setEntity(new StringEntity(param,"utf-8"));//把json字符串传入请求中
        //获取一个客户端对象
        CloseableHttpClient client = HttpClients.createDefault();
        //发送请求并获得一个响应对象
        CloseableHttpResponse response = client.execute(httpPost);
        //获取响应体
        HttpEntity entity = response.getEntity();
        String reponse_str = EntityUtils.toString(entity);
        System.out.println("注册：");
        System.out.println(reponse_str);


        /*
            2、登录
         */
        //初始化post请求，并添加请求头
        url = "/member/login";
        HttpPost post_login = new HttpPost(base_url + url);
        post_login.setHeader("X-Lemonban-Media-Type","lemonban.v2");
        post_login.setHeader("Content-Type","application/json");

        //把参数添加到请求体中，发送请求，获取响应体
        post_login.setEntity(new StringEntity(param,"utf-8"));
        CloseableHttpResponse response_login = client.execute(post_login);
        entity = response_login.getEntity();
        reponse_str = EntityUtils.toString(entity);
        System.out.println("用户登录：");
        System.out.println(reponse_str);

        //通过响应体获取id和token：把响应体json字符串转为JSONObject对象进行提取
        JSONObject jobj = JSONObject.parseObject(reponse_str);
        JSONObject data = (JSONObject) jobj.get("data");
        int id = (int)data.get("id");
        String token = (String) ((JSONObject) data.get("token_info")).get("token");




        /*
            3、用户信息（GET）
         */
        url = "/member/" + id + "/info";
        //初始化一个get请求,并添加请求头
        HttpGet get_info = new HttpGet(base_url+url);
        get_info.setHeader("X-Lemonban-Media-Type","lemonban.v2");
        get_info.setHeader("Authorization",token);

        //发送求请，并获取响应
        CloseableHttpResponse response_info = client.execute(get_info);
        reponse_str = EntityUtils.toString(response_info.getEntity());
        System.out.println("用户信息：");
        System.out.println(reponse_str);



        /*
            4、提现（Post）
         */
        url = "/member/withdraw";
        //初始化一个post请求,并添加请求头
        HttpPost post_draw = new HttpPost(base_url+url);
        post_draw.setHeader("X-Lemonban-Media-Type","lemonban.v2");
        post_draw.setHeader("Content-Type","application/json");
        post_draw.setHeader("Authorization",token);

        //添加参数，发送求请，并获取响应
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("member_id",id);
        jsonObject1.put("amount",1);
        post_draw.setEntity(new StringEntity(jsonObject1.toJSONString(),"utf-8"));
        CloseableHttpResponse response_draw = client.execute(post_draw);
        reponse_str = EntityUtils.toString(response_draw.getEntity());
        System.out.println("提现：");
        System.out.println(reponse_str);


        /*
            5、更新昵称（Patch）
         */
        url = "/member/update";
        //初始化一个patch请求,并添加请求头
        HttpPatch httpPatch = new HttpPatch(base_url + url);
        httpPatch.setHeader("X-Lemonban-Media-Type","lemonban.v2");
        httpPatch.setHeader("Content-Type","application/json");
        httpPatch.setHeader("Authorization",token);

        //添加参数，发送求请，并获取响应
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("member_id",id);
        jsonObject2.put("reg_name","修改后的name");
        httpPatch.setEntity(new StringEntity(jsonObject2.toJSONString(),"utf-8"));
        CloseableHttpResponse reponse_update = client.execute(httpPatch);
        reponse_str = EntityUtils.toString(reponse_update.getEntity());
        System.out.println("更新昵称：");
        System.out.println(reponse_str);

    }
}
