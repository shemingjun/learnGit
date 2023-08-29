package com.test.learn.easyexcel.hutoolWriter;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @Title: test1
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolWriter
 * @date 2023/8/29 19:16
 */
@Slf4j
public class test1 {

    public static void main(String[] args) {
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(TestFileUtil.getPath() + "writeTest" + System.currentTimeMillis() + ".xlsx");
        //通过构造方法创建writer
        //ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //合并单元格后的标题行，使用默认标题样式
        writer.merge(2, "测试标题");
        //一次性写出内容，强制输出标题
        writer.write(data(), true);
        //关闭writer，释放内存
        writer.close();

    }

    private static List<List<Object>> data() {
        List<List<Object>> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<Object> data = ListUtils.newArrayList();
            data.add("字符串" + i);
            data.add(0.56);
            data.add(new Date());
            list.add(data);
        }
        return list;
    }

}
