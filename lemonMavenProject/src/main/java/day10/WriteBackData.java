package day10;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 第一题
 * 1、定义WriteBackData类有三个私有属性rowNum（行号）; cellNum（列号）;content（内容）;(10分)
 * 2、创建3个WriteBackData对象 (10分)
 * w1：行号 1，列号 2，内容 Pass
 * w2：行号 2，列号 2，内容 Fail
 * w3：行号 3，列号 2，内容 Pass
 * 3、把w1、w2、w3放入ArrayList集合中。(10分)
 * 4、通过poi把ArrayList集合中的数据回写到exam.xls文件中第一个Sheet。(30分)
 * 回写规则：按照WriteBackData对象的rowNum行号和cellNum列号回写对应的excel中，content是回写的具体内容。
 */

public class WriteBackData {
    private int rowNum;
    private int cellNum;
    private String content;

    public WriteBackData() {
    }

    public WriteBackData(int rowNum, int cellNum, String content) {
        this.rowNum = rowNum;
        this.cellNum = cellNum;
        this.content = content;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getCellNum() {
        return cellNum;
    }

    public String getContent() {
        return content;
    }

    //程序主方法
    public static void main(String[] args) throws IOException {
        //创建3个WriteBackData对象
        WriteBackData w1 = new WriteBackData(1, 2, "Pass");
        WriteBackData w2 = new WriteBackData(2, 2, "Fail");
        WriteBackData w3 = new WriteBackData(3, 2, "Pass");

        //把w1、w2、w3放入ArrayList集合中
        List<WriteBackData> list = new ArrayList<>();
        list.add(w1);
        list.add(w2);
        list.add(w3);

        /*
            通过poi把ArrayList集合中的数据回写到exam.xls文件中第一个Sheet
         */
        FileInputStream fis = new FileInputStream("exam.xls");//此目录是相对于项目的路径
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        //调试代码：打印行列数
       /* for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
            short lastCellNum = sheet.getRow(i).getLastCellNum();
            System.out.println("第"+i+"行，"+lastCellNum+"列");
        }*/
        //调试代码：遍历打印excel中的内容
        /*for (Row row : sheet){
            for (Cell cell : row){
                if (cell != null) {
                    cell.setCellType(CellType.STRING);
                    System.out.print(cell.getStringCellValue() + ", ");
                }else
                    System.out.println("null,");
            }
            System.out.println();
        }*/

        //遍历WriteBackData对象的list
        for (WriteBackData w : list){
            int rowNum = w.getRowNum();//获取对象的行号
            int cellNum = w.getCellNum();//获取对象的列号

            Row row = sheet.getRow(rowNum);//根据行号获取excel的行

            /*
                根据WriteBackData对象来获取该行目前已存在的列数，当要写入数据的列不存在时，需要先创建列
             */
            //方法1）判断列是否存在 cellNum+1 > row.getLastCellNum()
//            Cell cell = null;
//            if (cellNum+1 > row.getLastCellNum()){
//                cell = row.createCell(cellNum);
//            }
//            cell = row.getCell(cellNum);
//            cell.setCellType(CellType.STRING);
//            cell.setCellValue(w.getContent());

            //方法2) 判断列是否存在 row.getCell(cellNum) == null
            Cell cell = row.getCell(cellNum);
            if (cell == null){
                cell = row.createCell(cellNum);
            }
            cell.setCellType(CellType.STRING);
            cell.setCellValue(w.getContent());
        }

        //调试代码：打印行列数
       /* for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
            short lastCellNum = sheet.getRow(i).getLastCellNum();
            System.out.println("第"+i+"行，"+lastCellNum+"列");
        }*/

        fis.close();
        //把内容存入到文件中
        FileOutputStream fos = new FileOutputStream("exam.xls");//此目录是相对于项目的路径
        workbook.write(fos);
        fos.close();
    }
}
