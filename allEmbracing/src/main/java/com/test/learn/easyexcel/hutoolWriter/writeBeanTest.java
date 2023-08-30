package com.test.learn.easyexcel.hutoolWriter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.TestBean;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smj
 * @Title: writeBeanTest
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolWriter
 * @date 2023/8/30 9:22
 */
@Slf4j
public class writeBeanTest {

    public static void main(String[] args) {
        one();
        two();
    }

    private static void two() {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(TestFileUtil.getPath() + "writeBeanTest2" + System.currentTimeMillis() + ".xlsx");
        //自定义标题别名
//        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("score", "分数");
        writer.addHeaderAlias("isPass", "是否通过");
        writer.addHeaderAlias("examDate", "考试时间");

        // 默认的，未添加alias的属性也会写出，如果想只写出加了别名的字段，可以调用此方法排除之
        writer.setOnlyAlias(true);

        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");

        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data(), true);
        // 关闭writer，释放内存
        writer.close();
    }

    private static void one() {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(TestFileUtil.getPath() + "writeBeanTest" + System.currentTimeMillis() + ".xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data(), true);
        // 关闭writer，释放内存
        writer.close();
    }

    private static List<TestBean> data() {
        List<TestBean> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            TestBean bean1 = new TestBean();
            bean1.setName("张三"+i);
            bean1.setAge(22+i);
            bean1.setPass(true);
            bean1.setScore(66.30+i);
            bean1.setExamDate(DateUtil.date());
            list.add(bean1);
        }
        return list;
    }

}
