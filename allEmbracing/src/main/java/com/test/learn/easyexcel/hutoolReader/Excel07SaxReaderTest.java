package com.test.learn.easyexcel.hutoolReader;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @author smj
 * @Title: Excel07SaxReaderTest
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolReader
 * @date 2023/9/4 9:45
 */

@Slf4j
public class Excel07SaxReaderTest {
    private static String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
    public static void main(String[] args) {
        one();
        two();
    }

    private static void two() {
        Excel07SaxReader reader = new Excel07SaxReader(createRowHandler());
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
}
