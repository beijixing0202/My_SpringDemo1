package net.bill99.base;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelDataProvider implements Iterator<Object[]> {
    HSSFSheet hssfSheet;
    POIFSFileSystem poifsFileSystem;
    int colFlag = 0;
    int rowFlag = 0;
    int usedRowFlag = 1;
    String[] colName = null;
    FileInputStream intputStream;
    /*
     * 构造方法
     * */
    public ExcelDataProvider(String className,String methodName) throws FileNotFoundException {
        //数据放到数据流里面
        intputStream = new FileInputStream(this.getPath(className));
        poifsFileSystem = null;
        try {
            poifsFileSystem = new POIFSFileSystem(intputStream);
            //打开  EXCEL工作薄
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
            //获取 sheet
            hssfSheet = hssfWorkbook.getSheet(methodName);
            //获取一行对象
            HSSFRow hssfRow = hssfSheet.getRow(0);
            //获取有多少列
            colFlag = hssfRow.getPhysicalNumberOfCells();
            //获取有多少行
            int rows = hssfSheet.getLastRowNum();
            colName = new String[colFlag];
            //获取所有的列名
            for (int i = 0; i < colFlag; i++) {
                colName[i] = hssfSheet.getRow(0).getCell(i).toString();
            }
            //获取有多少行
            for (int r = 1; r <= rows; r++) {
                try {
                    String v = hssfSheet.getRow(r).getCell(0).toString();
                    if (v == null || v.equals("")) {
                        break;
                    }
                } catch (NullPointerException e) {
                    break;
                }
                this.rowFlag++;
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * 判断是否仍有元素可以迭代
     * @return
     */
    @Override
    public boolean hasNext() {
        //行数大于0 并且 第一列有数据 并且 当前的行数小于等于 最大行
        if (rowFlag > 0 && hssfSheet.getRow(rowFlag).getCell(0).toString() != "" && usedRowFlag <= rowFlag)
            return true;  //To change body of implemented methods use File | Settings | File Templates.
        else {
            try {
                intputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return false;
        }
    }

    /**
     * 返回迭代的下一个元素
     * @return
     */
    @Override
    public Object[] next() {
        Object[] object = new Object[1];
        Map<String, String> map = new LinkedHashMap<String, String>();
        //遍历所有列
        for (int c = 0; c < colFlag; c++) {
            String cellValue = "";
            try {
                //获取单元格的值
                cellValue = hssfSheet.getRow(this.usedRowFlag).getCell(c).toString();
            } catch (Exception e) {
                map.put(colName[c], cellValue);
                continue;
            }
            // colName[c]  获取当前列的列头
            map.put(colName[c], cellValue);
        }
        this.usedRowFlag++;
        object[0] = map;
        return object;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 删除
     */
    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 获得TestData.xls的绝对路径
     * @return
     */
    public String getPath(String className) {

        String path= null;
        try {
            path = ResourceUtils.getFile("classpath:DataDriverSource/"+className+".xls").toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }
}
