package FiveOneWork;

/**
 *
 6、输出两个数组相同的内容，例如：{1,3,4,10} {11,3,13,55} 结果输出：3 （提示使用双重循环）
 */

public class SixthWork {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,10};
        int[] arr2 = {11,3,13,55};

        //调用方法输出两个数组相同的内容
        printSame(arr1,arr2);
    }


    //定义一个方法来输出两个数组中相同的数字
    public static void printSame(int[] arr1, int[] arr2){
        for (int a : arr1){
            for (int b : arr2){
                if (a==b)
                    System.out.println(a);
            }
        }
    }
}
