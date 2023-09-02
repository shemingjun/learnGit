package com.test.learn.easyexcel.read;

/**
 * @author smj
 * @Title: noModelRead
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.read
 * @date 2023/9/2 16:45
 */

import com.alibaba.excel.EasyExcel;
import com.test.learn.easyexcel.config.NoModelDataListener;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 不创建对象的读
 */
@Slf4j
public class noModelRead {
    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(fileName, new NoModelDataListener()).sheet().doRead();
    }
}
