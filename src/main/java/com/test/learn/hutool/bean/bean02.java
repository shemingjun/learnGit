package com.test.learn.hutool.bean;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: bean02
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.bean
 * @date 2023/2/13 10:28
 */
@Slf4j
public class bean02 {
    @Data
    public static class User {
        private String name;
        private int age;
        private boolean isAdmin;
        private boolean isSuper;
        private boolean gender;
    }
    public static void main(String[] args) {
        BeanDesc desc = BeanUtil.getBeanDesc(User.class);
        log.info("User:{}", desc.getSimpleName());
        log.info("User2:{}", desc.getName());

        log.info("age:{}", desc.getField("age").getName());
        log.info("getAge:{}", desc.getGetter("age").getName());
        log.info("setAge:{}", desc.getSetter("age").getName());
        log.info("1:{}", desc.getSetter("age").getParameterTypes().length);
        log.info("2:{}", desc.getSetter("age").getParameterTypes()[0]);
    }
}
