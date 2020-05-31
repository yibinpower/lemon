package day11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 2、使用 @dataProvider 对 register(String username,String password,String type,String sex)方法 进行5次测试
 */
public class HomeWork2 {

    @Test(dataProvider = "datas")
    public void register(String username,String password,String type,String sex){
        System.out.println("register() is running.");
        System.out.println(username+"-->"+password+"-->"+type+"-->"+sex);
    }

    @DataProvider
    public Object[][] datas(){
        System.out.println("datas() is running.");
        Object[][] datas = {
                {"user1","123","type1","man"},
                {"user2","456","type2","woman"},
                {"user3","789","type3","woman"},
                {"user4","012","type4","man"},
                {"user5","345","type5","man"}
        };
        return datas;
    }
}
