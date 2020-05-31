package FiveOneWork;

/**
 * 1、有字符串String s = "abc,123,中国,llllll,haha";
 * 最终输出：abc：3，123：3，中国：2，llllll:6，haha:4   数字代表长度
 */

public class NinthWork {
    public static void main(String[] args) {
        String s = "abc,123,中国,llllll,haha";
        //用字符串的分割方法来分割字符串，得到字符串数组
        String[] arrStr = s.split(",");
        //遍历字符串数组
        for (String temp : arrStr){
            System.out.println(temp + "：" + temp.length());
        }
    }
}
