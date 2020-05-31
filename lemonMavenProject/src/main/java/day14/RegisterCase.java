package day14;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author: YiBin
 * @Description: 注册 测试类
 * @Date: Created in 下午 03:49 20/05/15
 * @Modified By:
 */
public class RegisterCase {
    // 用例执行的数据源来源于dataProvider = "datas"；datas这个二维数组长度有多大就执行多少次迭代；参数就是数组中的元素
    @Test(dataProvider = "datas")
    public void test(CaseInfo caseInfo) throws IOException {
        String prettyResponse = HttpUtils.post(caseInfo.getUrl(), caseInfo.getParams());
        System.out.println(prettyResponse);
        System.out.println("============================================================");
    }

    // 数据提供者提供一个二维数组：二维数组长度是excel行数，也为用例执行次数；其内部的一维数组是一个CaseInfo对象，是一个整体
    @DataProvider(name = "datas")
    public Object[][] datas(){
        return ExcelUtils.read();
    }
}
