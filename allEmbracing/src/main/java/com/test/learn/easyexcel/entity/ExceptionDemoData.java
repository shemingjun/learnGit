package com.test.learn.easyexcel.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author smj
 * @Title: ExceptionDemoData
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.entity
 * @date 2023/9/2 16:34
 */
@Getter
@Setter
@EqualsAndHashCode
public class ExceptionDemoData {
    /**
     * 用日期去接字符串 肯定报错
     */
    private Date date;
}
