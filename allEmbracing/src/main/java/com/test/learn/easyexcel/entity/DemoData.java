package com.test.learn.easyexcel.entity;

import cn.hutool.core.annotation.Alias;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author smj
 * @Title: DemoData
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.entity
 * @date 2023/8/24 18:46
 */

@Getter
@Setter
@EqualsAndHashCode
public class DemoData {
    @ExcelProperty("字符串标题")
    @Alias("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    @Alias("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    @Alias("数字标题")
    private Double doubleData;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
