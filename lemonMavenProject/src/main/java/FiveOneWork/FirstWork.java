package FiveOneWork;

/**
 * 1、求1到1000的水仙花数，所谓的水仙花数就是一个三位数它的各个数的立方和等于该数本身。
 * 153他就是一个水仙花数，1的立方加上5的立方再加上3的立方就等于153。（1*1*1+5*5*5+3*3*3=153）
 */

public class FirstWork {
    public static void main(String[] args) {
        /*
            思路：
            1）、根据水仙花数的特点，需要根据这个三位数的每一位数字进行求三次幂（立方）。
            2）、可以通过%、/的方式来获取每一位数字
         */
        for (int i = 100; i < 1000; i++) {
            //获取最高位
            int first = (i/100)%10;
            //获取十位
            int second = (i/10)%10;
            //获取个位
            int third = i%10;

            //三位数的和为：
            double sum = Math.pow(first,3)+Math.pow(second,3)+Math.pow(third,3);
            //打印水仙花数
            if (sum == i){
                System.out.println("水仙花数："+i);
            }
        }
    }
}
