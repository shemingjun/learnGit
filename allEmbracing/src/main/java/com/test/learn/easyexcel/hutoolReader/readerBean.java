package com.test.learn.easyexcel.hutoolReader;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson2.JSON;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @author smj
 * @Title: readerBean
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolReader
 * @date 2023/9/4 8:36
 *
 * 读取为Bean列表，Bean中的字段名为标题，字段值为标题对应的单元格值。* *
 */

@Slf4j
public class readerBean {
    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader reader = ExcelUtil.getReader(fileName);
        List<DemoData> all = reader.readAll(DemoData.class);
        all.forEach(d -> log.info("all:{}", JSON.toJSONString(d)));
    }
}
