package com.test.learn.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSONObject;
import com.test.learn.easyexcel.entity.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author smj
 * @Title: HutoolExcel
 * @ProjectName learnGit
 * @packageName com.test.learn.controller
 * @date 2023/8/30 14:47
 */

@Slf4j
@RestController
@RequestMapping("/public")
public class HutoolExcel {

    @PostMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        //创建xlsx格式的
        //ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data(), true);
        //out为OutputStream，需要写出到的目标流
        writer.flush(response.getOutputStream());
        // 关闭writer，释放内存
        writer.close();
    }

    @PostMapping("/export2")
    public void export2(HttpServletResponse response) throws IOException {
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        //创建xlsx格式的
        //ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data(), true);

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=test.xls");
        ServletOutputStream out=response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    @PostMapping("/export3")
    public void export3(HttpServletResponse response) throws IOException {
        // 通过工具类创建writer，默认创建xls格式
//        ExcelWriter writer = ExcelUtil.getWriter();
        //创建xlsx格式的
//        ExcelWriter writer = ExcelUtil.getWriter(true);
        // Excel大数据生成-BigExcelWriter
        BigExcelWriter writer= ExcelUtil.getBigWriter();

        // 定义单元格背景色
        StyleSet style = writer.getStyleSet();
        // 第二个参数表示是否也设置头部单元格背景
        style.setBackgroundColor(IndexedColors.BLUE, false);

        //设置内容字体
        Font font = writer.createFont();
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setItalic(true);
        //第二个参数表示是否忽略头部样式
        style.setFont(font, true);



        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data(), true);

        writer.setSheet("sheet2");
        writer.write(data2(), true);

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=test_xlsx" + System.currentTimeMillis() + ".xlsx");
        ServletOutputStream out=response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
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

    private static List<TestBean> data2() {
        List<TestBean> list = ListUtils.newArrayList();
        for (int i = 0; i < 100; i++) {
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
