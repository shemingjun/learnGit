package com.test.learn.easyexcel.hutoolWriter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smj
 * @Title: writeMapTest
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolWriter
 * @date 2023/8/29 19:29
 */
@Slf4j
public class writeMapTest {

    public static void main(String[] args) {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(TestFileUtil.getPath() + "writeMapTest" + System.currentTimeMillis() + ".xlsx");
// 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");
// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data(), true);
// 关闭writer，释放内存
        writer.close();

    }
    private static List<Map<String, Object>> data() {
        List<Map<String, Object>> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> row1 = new LinkedHashMap<>();
            row1.put("姓名", "张三"+i);
            row1.put("年龄", 23+i);
            row1.put("成绩", 88.32+i);
            row1.put("是否合格", true);
            row1.put("考试日期", DateUtil.date());
            list.add(row1);
        }
        return list;
    }
}
