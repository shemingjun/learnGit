package com.test.learn.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.ComplexHeadData;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @Title: complexHeadWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/24 19:15
 * *
 * 使用{@link ExcelProperty}注解指定复杂的头*
 */

@Slf4j
public class complexHeadWrite {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "complexHeadWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(data());

    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
