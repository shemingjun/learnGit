package com.test.learn.utils.hutool.collection;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.FilterIter;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.collection.ListUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smj
 * @Title: IterUtil01
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.hutool.collection
 * @date 2023/2/17 11:26
 */
@Slf4j
public class IterUtil01 {
    public static void main(String[] args) {
        final ArrayList<String> list = CollUtil.newArrayList("1", "2", "3", "4");
        final String join = IterUtil.join(list.iterator(), ":");
        final String join2 = IterUtil.join(list.iterator(), ",");
        log.info("join: {}" , join);
        log.info("join2: {}" , join2);

        final ArrayList<Integer> list2 = CollUtil.newArrayList(1, 2, 3, 4);
        final String join3 = IterUtil.join(list2.iterator(), ":");
        final String join4 = IterUtil.join(list2.iterator(), ",");
        log.info("join3: {}" , join3);
        log.info("join4: {}" , join4);

        final List<String> obj2 = ListUtil.toList("3");
        final List<String> obj = ListUtil.toList("1", "3");

        final FilterIter<String> filtered = IterUtil.filtered(obj.iterator(), obj2::contains);
        log.info("filtered: {}" , JSON.toJSONString(filtered.next()));

        final List<String> filtered1 = IterUtil.filterToList(obj.iterator(), obj2::contains);
        log.info("filtered1: {}" , JSON.toJSONString(filtered1));


    }
}
