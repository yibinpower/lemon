package day09;

import com.alibaba.fastjson.JSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: YiBin
 * @Description:
 * @Date: Created in 上午 09:23 20/04/28
 * @Modified By:
 */
public class HomeWork {
    public static void main(String[] args) {
        /*
            1、String json = {"name": "张三", "age": "18", "score":"100"}; 析成Student对象。
         */
        System.out.println("第一题：");

        String json = "{\"name\": \"张三\", \"age\": \"18\", \"score\":\"100\"}";
        Student student = JSON.parseObject(json, Student.class);
        System.out.println("将json字符串解析为Student对象的结果："+student);
        System.out.println("--------------------------------------------------------");




        /*
            2、String json = 	[{"name": "张三", "age": "18", "score":"100"},{"name": "李四", "age": "16", "score":"100"}] 解析成List<Student>对象。
         */
        System.out.println("第二题：");

        String jsonArr = "[{\"name\": \"张三\", \"age\": \"18\", \"score\":\"100\"},{\"name\": \"李四\", \"age\": \"16\", \"score\":\"100\"}]";
        List<Student> studentArr = JSON.parseArray(jsonArr, Student.class);
        System.out.println("将json字符串解析为Student对象的集合结果：");
        for (int i = 0; i < studentArr.size(); i++) {//遍历集合中的Student对象
            System.out.println(studentArr.get(i));
        }
        System.out.println("--------------------------------------------------------");



        /*
            3、有config.properties文件内容如下
            username=zhangsan
            password=123456
            使用Properties类的中方法读取到java程序中并输出在控制台上。
         */
        System.out.println("第三题：");

        Properties properties = new Properties();//初始化Properties集合
        FileInputStream fileInputStream = null;//定义字节输入流
        try {
            fileInputStream = new FileInputStream("src\\main\\resources\\config.properties");
            properties.load(fileInputStream);//加载字节流内容到properties集合中
            System.out.println(properties);//打印从配置文件中获取到的集合

            //从properties集合中得到键的集合，然后根据键遍历值
            Set<String> names = properties.stringPropertyNames();
            for (String name : names){
                System.out.println(name + ": " + properties.get(name));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------------------------------------------------");




         /*
            4、把下面json字符串解析成java对象（扩展题目，可以不做）
            { "name": "中国", "provinces": [{ "name": "黑龙江", "capital": "哈尔滨" },
            { "name": "广东", "capital": "广州" }, { "name": "湖南", "capital": "长沙" }] }
         */
        System.out.println("第四题：");

        String jsonCountry = "{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" },\n" +
                "            { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }] }";

        Country country = JSON.parseObject(jsonCountry, Country.class);//把json字符串反序列化为java的Country对象
        System.out.println(JSON.toJSONString(country));//打印Country对象的序列化值

        System.out.println("国家名称为： "+ country.getName());//打印国家名
        //获取国家下面的省对象集合，遍历省
        Set<Province> provinces = country.getProvinces();
        for (Province p : provinces){
            System.out.println("省：" + p);
        }

    }
}
