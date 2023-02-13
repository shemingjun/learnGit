package com.test.learn.hutool.bean;

import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author smj
 * @Title: bean01
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.bean
 * @date 2023/2/13 10:07
 */
@Slf4j
public class bean01 {
    @Data
    private static class A {
        private String value;
        private String name;
        private Integer age;
    }
    @Data
    private static class B {
        private String value;
    }

    public static void main(String[] args) {
        final A a = new A();
        a.setValue("test");
        HashMap<Object, Object> map = BeanCopier.create(a, new HashMap<>(), CopyOptions.create()).copy();
        log.info("{}", map);

        final B b = new B();
        b.setValue("abc");
        map = BeanCopier.create(a, new HashMap<>(), CopyOptions.create().ignoreNullValue()).copy();
        log.info("{}", map);


//        final BeanCopier<B> copier = BeanCopier.create(a, b, CopyOptions.create().setOverride(false));
        final BeanCopier<B> copier = BeanCopier.create(a, b, CopyOptions.create().setOverride(true));
        copier.copy();

        log.info("a:{}", a);
        log.info("b:{}", b);
    }


}
