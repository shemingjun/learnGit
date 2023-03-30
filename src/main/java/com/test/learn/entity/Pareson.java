package com.test.learn.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author smj
 * @Title: pareson
 * @ProjectName learnGit
 * @packageName com.test.learn.entity
 * @date 2023/2/24 10:12
 */
@Data
public class Pareson implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
}
