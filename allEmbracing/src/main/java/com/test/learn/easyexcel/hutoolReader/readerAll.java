package com.test.learn.easyexcel.hutoolReader;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson2.JSON;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @author smj
 * @Title: test
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolReader
 * @date 2023/9/1 11:07
 *
 * 读取Excel中所有行和列，都用列表表示
 */
@Slf4j
public class readerAll {
    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader reader = ExcelUtil.getReader(fileName);
        List<List<Object>> readAll = reader.read();
        readAll.forEach(d -> log.info("readAll:{}", JSON.toJSONString(d)));
    }
}
