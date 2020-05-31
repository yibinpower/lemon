package day10;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 第二题 主函数类
 */

public class SecondWork {
    public static void main(String[] args) {
        //json字符串：
        String s1 = "[{\"value\":0,\"expression\":\"$.code\"},{\"value\":\"OK\",\"expression\":\"$.msg\"},{\"value\":\"OK\",\"expression\":\"OK\"}]";
        String s2 = " [{\"value\":\"OK\",\"expression\":\"OK\"},{\"value\":\"OK\",\"expression\":\"OK\"},{\"value\":\"OK\",\"expression\":\"OK\"}]";

        //把s1、s2两个字符串转成两个List<JsonValidate>集合
        List<JsonValidate> jsonValidatesArr1 = JSON.parseArray(s1, JsonValidate.class);
        List<JsonValidate> jsonValidatesArr2 = JSON.parseArray(s2, JsonValidate.class);

        //循环s1的List集合，如果value和expression相等则输出Pass，否则输出Fail
        for (JsonValidate jsonValidate : jsonValidatesArr1){
            String temp = (jsonValidate.getValue().equals(jsonValidate.getExpression())) ? "Pass" : "Fail";
            System.out.println(temp);
        }
    }
}
