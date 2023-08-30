package com.test.learn.easyexcel.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author smj
 * @Title: TestBean
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.entity
 * @date 2023/8/30 9:24
 */

@Getter
@Setter
@EqualsAndHashCode
public class TestBean {
    private String name;
    private int age;
    private double score;
    private boolean isPass;
    private Date examDate;
}
