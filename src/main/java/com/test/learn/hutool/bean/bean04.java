package com.test.learn.hutool.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * @author smj
 * @Title: bean04
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.bean
 * @date 2023/2/13 11:52
 */

@Slf4j
public class bean04 {

    public static void main(String[] args) {
        final Map<String, Object> map = MapBuilder.<String, Object>create()
                .put("Name", "Joe")
                .put("aGe", 12)
                .put("openId", "DFDFSDFWERWER")
                .build();
        final SubPerson person = BeanUtil.fillBeanWithMapIgnoreCase(map, new SubPerson(), false);
        log.info("person:{}", person);
    }


    @Data
    public static class SubPerson extends Person {

        public static final String SUBNAME = "TEST";

        private UUID id;
        private String subName;
        private Boolean slow;
        private LocalDateTime date;
        private LocalDate date2;
    }

    @Data
    public static class Person {
        private String name;
        private int age;
        private String openid;
    }
}
