package FiveOneWork;

/**
 * 2、判断一个数是否是回文数，是则输出Y，否则输出N。
 * 回文数是指将该数含有的数字逆序排列后得到的数和原数相同， 例如12121、3223都是回文数。
 */

public class TenthWork {
    public static void main(String[] args) {
        int[] intArr = {12121, 3223, 5242, 63587, 76567};
        for (int i : intArr){
            System.out.println("当前数字：" + i + "，是否是回文数：" + palindromicNumber2(i));
        }
    }


    //写一个方法来判断回文数，则输出Y，否则输出N 。方法1：遍历倒序字符串来实现：
    public static String palindromicNumber1(int x){
        //先把int转为String
        String s = Integer.toString(x);
        //再遍历字符串，把字符串倒序排列
        String temp = "";
        for (int i = s.length(); i > 0 ; i--) {
            temp += s.substring(i-1,i);
        }
        //最后把字符串转为int
        int y = Integer.parseInt(temp);
        //反转后的int和源int比较返回Y或N
        String result = (y==x)?"Y":"N";
        return result;
    }

    //写一个方法来判断回文数，则输出Y，否则输出N 。方法2：通过StringBuilder类直接反转字符串来实现
    public static String palindromicNumber2(int x){
        //int转字符串
        String s = String.valueOf(x);
        //字符串转StringBuilder
        StringBuilder stringBuilder = new StringBuilder(s);
        //反转StringBuilder对象
        StringBuilder reverse = stringBuilder.reverse();
        //StringBuilder转String
        String strReverse = reverse.toString();
        //String转Integer
        int y = Integer.parseInt(strReverse);

        //反转后的int和源int比较返回Y或N
        return (y==x)?"Y":"N";
    }
}
