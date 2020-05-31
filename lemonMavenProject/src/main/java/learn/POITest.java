package learn;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class POITest {
    public static void main(String[] args) throws IOException {
        //一、读excel
        FileInputStream fis = new FileInputStream("D:/test.xlsx");
        Workbook excel = WorkbookFactory.create(fis);
        Sheet sheet = excel.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("excel行数："+lastRowNum);
        for (int i = 0; i < lastRowNum+1 ; i++) {
            Row row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum();
            System.out.println("第"+i+"行的列数："+lastCellNum);
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row.getCell(j);
                //没有编辑过的表格，是一个空对象，直接去获取值会报异常；所以需要判断
                if (cell != null){
                    cell.setCellType(CellType.STRING);
                    System.out.print(cell.getStringCellValue()+", ");
                }else
                    System.out.print(",");
            }
            System.out.println("\n----------------------------------------------");
        }
        fis.close();


        //二、写excel
        FileInputStream fis1 = new FileInputStream("D:/test.xlsx");
        Workbook excel1 = WorkbookFactory.create(fis1);
        Sheet sheet1 = excel1.getSheetAt(0);
        int lastRowNum1 = sheet1.getLastRowNum();
        //1）、当处理的行数小于最后一行，则修改
        Row row1 = sheet1.getRow(lastRowNum1);
        short lastCellNum1 = row1.getLastCellNum();//获取列数
        for (int i = 0; i < lastCellNum1; i++) {
            Cell cell1 = row1.getCell(i);
            cell1.setCellType(CellType.STRING);
            String stringCellValue = cell1.getStringCellValue();
            cell1.setCellValue(stringCellValue+"_修改");
        }
        fis1.close();

        //把获取到的数据加上"_修改"然后再写入原来的表格中
        FileOutputStream fos = new FileOutputStream("D:/test.xlsx");
        excel1.write(fos);
        fos.close();


        //2)、当需要处理的行比最后一行的行号大，则是新增行，需要先创建行和表格
        int line = lastRowNum1 + 5;
        for (int i = lastRowNum1 + 1; i < line; i++) {
            Row row = sheet1.createRow(i);
            for (int j = 0; j < 4; j++) {
                Cell cell = row.createCell(j);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("新增-"+j);
            }
        }
        FileOutputStream fos2 = new FileOutputStream("D:/test.xlsx");
        excel1.write(fos2);
        fos2.close();
    }
}
