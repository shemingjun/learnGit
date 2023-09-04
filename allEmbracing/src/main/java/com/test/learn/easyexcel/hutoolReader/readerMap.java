package com.test.learn.easyexcel.hutoolReader;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson2.JSON;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author smj
 * @Title: readerMap
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolReader
 * @date 2023/9/4 8:23
 *
 * 读取为Map列表，默认第一行为标题行，Map中的key为标题，value为标题对应的单元格值。* *
 */

@Slf4j
public class readerMap {
    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader reader = ExcelUtil.getReader(fileName);
        List<Map<String,Object>> readAll = reader.readAll();
        readAll.forEach(d -> log.info("readAll:{}", JSON.toJSONString(d)));
    }
}
