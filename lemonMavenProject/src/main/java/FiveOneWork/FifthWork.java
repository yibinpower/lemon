package FiveOneWork;

/**
 * 5、在一个类中提供多个重载print()方法，可以遍历int[]、String[]、double[]数组。
 */

public class FifthWork {
    public static void main(String[] args) {
        //定义三个变量
        int[] arrInt = {3,45,23,75,11,34};
        String[] arrStr = {"ss","wer","baidu"};
        double[] arrDouble = {36.24,54.22,2.1,6.3};

        //分别传入三种类型的变量进行来调用重载方法
        print(arrInt);
        print(arrStr);
        print(arrDouble);
    }


    /*
        print()方法重载
     */
    public static void print(int[] arrInt){
        for (int a : arrInt){
            System.out.print(a+",");
        }
        System.out.println();
        System.out.println("-------------------------------");
    }

    public static void print(String[] arrStr) {
        for (String a : arrStr) {
            System.out.print(a + ",");
        }
        System.out.println();
        System.out.println("-------------------------------");
    }

    public static void print(double[] arrDouble){
        for (double a : arrDouble){
            System.out.print(a+",");
        }
        System.out.println();
        System.out.println("-------------------------------");
    }
}
