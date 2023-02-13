package com.test.learn.hutool.map;

import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author smj
 * @Title: map01
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.map
 * @date 2023/2/13 11:15
 */
@Slf4j
public class map01 {
    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");
        map1.put("d", "4");
        map1.put("e", "5");
        list.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("a", "2");
        map2.put("b", "3");
        map2.put("c", "4");
        map2.put("d", "5");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("a", "3");
        map3.put("b", "4");
        map3.put("c", "5");
        list.add(map3);

        Map<String, String> map4 = new HashMap<>();
        map4.put("a", "4");
        map4.put("b", "5");
        map4.put("c", "51");
        list.add(map4);

        Map<String, String> map5 = new HashMap<>();
        map5.put("a", "5");
        map5.put("b", "6");
        map5.put("c", "7");
        map5.put("d", "8");
        map5.put("e", "9");
        map5.put("f", "12");
        list.add(map5);

        Map<String,List<String>> resultMap1 = MapUtil.toListMap(list);
        log.info("resultMap1:{}", resultMap1);

        // // TODO: 2023/2/13  有bug ??? 
        List<Map<String,String>> mapList = MapUtil.toMapList(resultMap1);
        log.info("mapList:{}", mapList);
    }
}
