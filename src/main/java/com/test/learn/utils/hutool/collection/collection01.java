package com.test.learn.utils.hutool.collection;

import cn.hutool.core.collection.CollStreamUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author smj
 * @Title: collection01
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.hutool.collection
 * @date 2023/2/16 11:01
 */
@Slf4j
public class collection01 {

    public static void main(String[] args) {
        Map<Long, String> map2 = new HashMap<>();
        Map<Long, List<Student>> map3 = new HashMap<>();
        Map<Long, Map<Long, List<Student>>> map4 = new HashMap<>();
        Map<Long, Map<Long, Student>> map5 = new HashMap<>();
        Map<Long, List<String>> map6 = new HashMap<>();
        Map<Long, Student> map = CollStreamUtil.toIdentityMap(null, Student::getStudentId);
        log.info("map1{}", map);
        List<Student> list = new ArrayList<>();
        map = CollStreamUtil.toIdentityMap(list, Student::getStudentId);
        log.info("map2{}", map);
        list.add(new Student(1, 1, 1, "张三"));
        list.add(new Student(1, 1, 2, "李四"));
        list.add(new Student(1, 1, 3, "王五"));
        map = CollStreamUtil.toIdentityMap(list, Student::getStudentId);
        log.info("map3{}", map);

        list.add(new Student(1, 1, 1, "张三01"));
        map3 = CollStreamUtil.groupByKey(list, Student::getStudentId);
        log.info("map3.0{}", map3);

        list.add(new Student(1, 2, 1, "张三-2"));
        list.add(new Student(1, 2, 2, "李四-2"));
        list.add(new Student(1, 3, 3, "王五-3"));
        list.add(new Student(1, 4, 3, "赵柳-4"));
        map4 = CollStreamUtil.groupBy2Key(list, Student::getClassId, Student::getStudentId);
        log.info("map4.4{}", map4);

        Map<Long,Student> map11 = new HashMap<>();
        map11.put(1L, new Student(1, 1, 1, "张三"));
        Map<Long,Student> map12 = new HashMap<>();
        map12.put(1L, new Student(2, 1, 2, "李四"));
        Map<Long, String> merge = CollStreamUtil.merge(map11,map12, (s1, s2) -> s1.getName() + s2.getName());
        log.info("merge:{}", merge);

        Set<String> set = CollStreamUtil.toSet(list,Student::getName);
        log.info("set{}", set);

        List<String> map10 = CollStreamUtil.toList(list,Student::getName);
        log.info("map10{}", map10);

        Map<Long,Long> map9 = CollStreamUtil.groupBy(list,Student::getClassId, Collectors.counting());
        log.info("map9{}", map9);

        Map<Long,List<Student>> map8 = CollStreamUtil.groupBy(list,Student::getClassId, Collectors.toList());
        log.info("map8{}", map8);

        Map<Long,Optional<Student>> map7 = CollStreamUtil.groupBy(list,Student::getClassId, Collectors.maxBy(Comparator.comparing(Student::getStudentId)));
        log.info("map7{}", map7);

        map6 = CollStreamUtil.groupKeyValue(list,Student::getStudentId,Student::getName);
        log.info("map6{}", map6);

        map5 = CollStreamUtil.group2Map(list,Student::getClassId,Student::getStudentId);
        log.info("map5.5{}", map5);

        map2 = CollStreamUtil.toMap(list, Student::getStudentId, Student::getName);
        log.info("map3.1{}", map2);

        list.add(new Student(1, 1, 1, "张三01"));
        map = CollStreamUtil.toIdentityMap(list, Student::getStudentId,true);
        log.info("map4{}", map);

        list.add(null);
        map = CollStreamUtil.toIdentityMap(list, Student::getStudentId);
        log.info("map5{}", map);
    }


    /**
     * 班级类
     */
    @Data
    @AllArgsConstructor
    @ToString
    public static class Student {
        private long termId;//学期id
        private long classId;//班级id
        private long studentId;//班级id
        private String name;//学生名称
    }
}
