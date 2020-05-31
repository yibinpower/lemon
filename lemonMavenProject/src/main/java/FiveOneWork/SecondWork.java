package FiveOneWork;

/**
 * 2、控制台输出九九乘法表
 */

public class SecondWork {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+" ");
            }
            System.out.println();
        }
    }
}
