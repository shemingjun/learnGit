package com.test.learn.hutool.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.map.MapUtil;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: bean03
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.bean
 * @date 2023/2/13 10:59
 */

@Slf4j
public class bean03 {
    @Data
    @Builder
    public static class A {
        private String carNo;
    }

    @Data
    @Builder
    public static class B {
        private String car;
    }

    @Data
    @Builder
    public static class C {
        private String carNo;
    }

    public static void main(String[] args) {
        final CopyOptions copyOptions = CopyOptions.create()
                .setFieldMapping(MapUtil.of("car", "carNo"));

        B b = B.builder().car("12312312").build();
        A a = A.builder().build();
        C c = C.builder().build();
        BeanUtil.copyProperties(b, a, copyOptions);
        BeanUtil.copyProperties(a, c);

        log.info("{}", c.getCarNo());
    }
}
