package com.test.learn.easyexcel.hutoolReader;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.Excel03SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @author smj
 * @Title: Excel03SaxReader
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolReader
 * @date 2023/9/4 9:26
 *
 * 在标准的ExcelReader中，如果数据量较大，读取Excel会非常缓慢，并有可能造成内存溢出。
 * 因此针对大数据量的Excel，Hutool封装了event模式的读取方式。
 */
/**
 * @author smj
 * @date 2023/9/4 9:26
 * @since 1.0
 *
 * 首先我们实现一下RowHandler接口，这个接口是Sax读取的核心，通过实现handle方法编写我们要对每行数据的操作方式（比如按照行入库，入List或者写出到文件等），在此我们只是在控制台打印。
*/
@Slf4j
public class Excel03SaxReaderTest {
    private static String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo2.xls";
    public static void main(String[] args) {
        one();
        two();
    }

    private static void two() {
        Excel03SaxReader reader = new Excel03SaxReader(createRowHandler());
        // reader方法的第二个参数是sheet的序号，-1表示读取所有sheet，0表示第一个sheet，依此类推。
        reader.read(fileName, -1);
    }

    // ExcelUtil快速读取
    private static void one() {
        ExcelUtil.readBySax(fileName, 1, createRowHandler());
    }

    private static RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, long rowIndex, List<Object> rowCells) {
                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowCells);
            }
        };
    }

    // lambda 写法
    /*private static RowHandler createRowHandler() {
        return (sheetIndex, rowIndex, rowCells) -> Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowCells);
    }*/
}
