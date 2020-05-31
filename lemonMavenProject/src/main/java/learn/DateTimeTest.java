package learn;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

/**
 * @Author: YiBin
 * @Description:
 * @Date: Created in 下午 05:17 20/04/28
 * @Modified By:
 */
public class DateTimeTest {
    public static void main(String[] args) {
        /*
            1、日期操作LocalDate
         */
        //LocalDate获取今天日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期为：" + today);

        //通过LocalDate获取年月日
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("年："+year+"，月："+month+"，日："+day);

        //获取某个特定的日期
        LocalDate dateSet = LocalDate.of(2020, 3, 25);

        //获取1周后的日期
        LocalDate plus = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期是："+plus);

        //获取1年前的日期
        LocalDate predate = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期是："+predate);

        System.out.println("----------------------------------");



        /*
            2、时间操作LocalTime
         */
        //获取时间：LocalTime类，默认的格式是hh:mm:ss:nnn
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间："+localTime);

        //获取两个小时来计算之后的时间
        LocalTime localTime1 = localTime.plusHours(2);
        System.out.println("2小时候的时间："+localTime1);

        System.out.println("----------------------------------");




        /*
            3、年月对象YearMonth
         */
        //查询月份有多少天
        YearMonth yearMonth = YearMonth.now();
        System.out.printf("这个月的年月%s有：%d天%n",yearMonth,yearMonth.lengthOfMonth());

        //设置年月对象
        YearMonth yearMonthSet = YearMonth.of(2020, Month.DECEMBER);
        System.out.println("设置的年月是："+yearMonthSet);

    }
}
