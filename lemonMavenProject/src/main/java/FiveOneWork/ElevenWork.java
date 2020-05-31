package FiveOneWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1、有字符串String s = "AAAbcccccc";分别统计每个字符出现的次数。
 * 最终输出：A：3 b:1 c:6（使用HashMap完成）
 */

public class ElevenWork {
    public static void main(String[] args) {
        String s = "AAAbcccccc";
        //调用自定义方法来统计字符串中各个字符出现的次数，得到Map
        Map<Character, Integer> map = countChar(s);
        //遍历Map
        Set<Character> set = map.keySet();
        for (Character c : set){
            System.out.println(c + ":" + map.get(c));
        }
    }


    //定义方法 统计每个字符出现的次数
    public static Map<Character, Integer> countChar(String str) {
        //定义一个HashMap来接收最后字符统计的结果
        Map<Character, Integer> hashMap = new HashMap<>();
        //将字符串转成字符数组
        char[] chars = str.toCharArray();
        //遍历字符数组，把字符当作key去判断是否包含在Map中，存在的话就把value加1
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            char c = chars[i];
            if (hashMap.containsKey(c)){
                count = hashMap.get(c) + 1;
            }
            hashMap.put(c,count);
        }
        return hashMap;
    }

}
