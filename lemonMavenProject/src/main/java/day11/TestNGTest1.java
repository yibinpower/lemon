package day11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest1 {
    @Test(dataProvider = "datas")
    public void f(String  name, String passwd){
        System.out.println("TestNGTest1.f()");
        System.out.println(name + "--->" + passwd);
    }

    @Test
    public void k(){
        System.out.println("TestNGTest1.k()");
    }

    @DataProvider(name="datas")
    public Object[][] datas(){
        System.out.println("TestNGTest.datas()");
        Object[][] data = {{"zhangsan","123"},{"lisi","234"},{"wanngwu","345"}};
        return data;
    }
}
