package com.test.learn.hutool.collection;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author smj
 * @Title: coll02
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.collection
 * @date 2023/2/16 14:05
 */
@Slf4j
public class coll02 {
    public static void main(String[] args) {
        final ArrayList<String> list = CollUtil.newArrayList("bbbbb", "aaaaa", "ccccc");
        log.info("list: {}" , list );

        ArrayList<Integer> list2 = CollUtil.newArrayList(1, 2, 3);
        log.info("list2: {}" , list2 );
        List<Integer> resultList = CollUtil.removeWithAddIf(list2, ele -> 1 == ele);
        log.info("resultList: {}" , resultList );

        final ArrayList<String> list3 = CollUtil.newArrayList("a", "b", "b", "c", "d", "x");
        final ArrayList<String> list4 = CollUtil.newArrayList("a", "b", "b", "b", "c", "d", "e");
        final Collection<String> union = CollUtil.union(list3, list4);
        log.info("union: {}" , union );

        final Collection<String> intersection = CollUtil.intersection(list3, list4);
        log.info("intersection: {}" , intersection );

        final Collection<String> intersectionDistinct = CollUtil.intersectionDistinct(list3, list4);
        log.info("intersectionDistinct: {}" , intersectionDistinct );

        final Collection<String> disjunction = CollUtil.disjunction(list3, list4);
        final Collection<String> disjunction2 = CollUtil.disjunction(list4, list3);
        log.info("disjunction: {}" , disjunction );
        log.info("disjunction2: {}" , disjunction2 );

        final Collection<String> subtract = CollUtil.subtract(list3, list4);
        final Collection<String> subtract2 = CollUtil.subtract(list4, list3);
        log.info("subtract: {}" , subtract );
        log.info("subtract2: {}" , subtract2 );

        final ArrayList<String> list5 = CollUtil.newArrayList("1", "2", "3");
        final ArrayList<String> list6 = CollUtil.newArrayList("a", "b", "c");
        final Collection<String> disjunction3 = CollUtil.disjunction(list5, list6);
        log.info("disjunction3: {}" , disjunction3 );
    }
}
