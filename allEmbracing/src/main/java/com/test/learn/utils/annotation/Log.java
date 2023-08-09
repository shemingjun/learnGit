package com.test.learn.utils.annotation;

import com.test.learn.utils.enums.BusinessType;
import com.test.learn.utils.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @author smj
 * @Title: Log
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.annotation
 * @date 2023/7/4 16:14
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}
