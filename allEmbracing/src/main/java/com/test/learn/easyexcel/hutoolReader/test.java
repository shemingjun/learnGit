package com.test.learn.easyexcel.hutoolReader;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author smj
 * @Title: test
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolReader
 * @date 2023/9/1 11:07
 */
@Slf4j
public class test {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("d:/aaa.xlsx");
        List<List<Object>> readAll = reader.read();
    }
}
