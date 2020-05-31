package day11;
import org.testng.annotations.*;
/**
 * 1、用代码说明 @BeforeSuite  @BeforeTest @BeforeClass @BeforeMethod 执行顺序
 * 2、使用 @dataProvider 对 register(String username,String password,String type,String sex)方法 进行5次测试
 */
public class HomeWork1 {
    @Test
    public void fTest(){
        System.out.println("fTest runninig.");
    }

    @BeforeTest
    public void fBeforeTest(){
        System.out.println("fBeforeTest runninig.");
    }

    @BeforeMethod
    public void fBeforeMethod(){
        System.out.println("fBeforeMethod runninig.");
    }

    @BeforeSuite
    public void fBeforeSuite(){
        System.out.println("fBeforeSuite runninig.");
    }

    @BeforeClass
    public void fBeforeClass(){
        System.out.println("fBeforeClass runninig.");
    }
}
