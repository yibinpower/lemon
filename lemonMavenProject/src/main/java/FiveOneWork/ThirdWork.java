package FiveOneWork;

import java.util.Scanner;

/**
 * 3、猜数字游戏，定义一个num=35（任意数字），循环键盘输入一个数，如果大了提示大了，如果小了提示小了， 直到输入的数和定义的num相等，才终止循环结束程序。
 */

public class ThirdWork {
    public static void main(String[] args) {
        int num = 35;
        //循环判断
        while (true){
            System.out.println("请输入一个整数：");
            //键盘输入一个数字
            Scanner scanner = new Scanner(System.in);
            //输入不是int则继续输入
            if (!scanner.hasNextInt()){
                System.out.println("数据格式不正确，请重新输入！");
            }
            //判断输入的是int则进行判断
            else{
                int x = scanner.nextInt();//保存键盘输入的数据
                if (x > num){
                    System.out.println("大了，请再来一次。");
                }
                else if (x < num) {
                    System.out.println("小了，请再来一次。");
                }
                else {
                    System.out.println("恭喜你，猜对了！");
                    break;
                }
            }
        }
    }
}
