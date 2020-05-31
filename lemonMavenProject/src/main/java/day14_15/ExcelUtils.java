package day14_15;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Author: YiBin
 * @Description: 读excel工具类
 * @Date: Created in 下午 01:47 20/05/15
 * @Modified By:
 */
public class ExcelUtils {
    public static void main(String[] args) {
        read(1,1);
    }


    /**
     * 读excel的方法
     * @return
     */
    public static Object[][] read(int startSheetIndex, int sheetNum){
        Object[][] datas = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Constants.EXCEL_PATH);//读取常量类中的常量
            //excel导入配置
            ImportParams importParams = new ImportParams();
            //从startSheetIndex位置开始读sheet
            importParams.setStartSheetIndex(startSheetIndex);
            //读几个sheet
            importParams.setSheetNum(sheetNum);
            //获取CaseInfo类实例的list
            List<CaseInfo> list = ExcelImportUtil.importExcel(fis, CaseInfo.class, importParams);

            //把list中的对象存入到datas二维数组中
            datas = new Object[list.size()][1];
            for (int i = 0; i < list.size(); i++) {
                datas[i][0] = list.get(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return datas;
    }

}
