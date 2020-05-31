package day13;

import org.apache.poi.ss.formula.functions.T;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @Author: YiBin
 * @Description:
 * @Date: Created in 下午 08:18 20/05/12
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        Class<Test> testClass = Test.class;
        String path = testClass.getResource("/").getPath();
        System.out.println(path);
    }

    public <T> void save(List<T> list){

    }
}
