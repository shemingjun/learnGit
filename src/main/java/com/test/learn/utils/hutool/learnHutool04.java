package com.test.learn.utils.hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 时间处理
 * @author smj
 * @Title: learn03
 * @ProjectName learnGit
 * @date 2023/2/8 13:33
 */
@Slf4j
public class learnHutool04 {
    public static void main(String[] args) {
        log.info("当前时间:{}", DateUtil.now());
        log.info("当前时间:{}", DateUtil.date());
        log.info("当前时间:{}", DateUtil.dateSecond());
        log.info("时间戳转时间:{}", DateUtil.date(System.currentTimeMillis()));
        log.info("当前时间戳:{}", DateUtil.current());
        log.info("纳秒:{}",System.nanoTime());
        log.info("当前时间戳秒:{}", DateUtil.currentSeconds());
        log.info("当前时间:{}", DateUtil.today());
        log.info("当前时间-年:{}", DateUtil.year(DateUtil.date()));
        log.info("当前时间-季度:{}", DateUtil.quarter(DateUtil.date()));
        log.info("当前时间-季度:{}", DateUtil.quarterEnum(DateUtil.date()));
        log.info("当前时间-月份:{}", DateUtil.month(DateUtil.date()));
        log.info("当前时间-月份:{}", DateUtil.monthEnum(DateUtil.date()));
        log.info("当前时间-年周:{}", DateUtil.weekOfYear(DateUtil.date()));
        log.info("当前时间-月周:{}", DateUtil.weekOfMonth(DateUtil.date()));
        log.info("当前时间-天月:{}", DateUtil.dayOfMonth(DateUtil.date()));
        log.info("当前时间-天年:{}", DateUtil.dayOfYear(DateUtil.date()));
        log.info("当前时间-天周:{}", DateUtil.dayOfWeek(DateUtil.date()));
        log.info("当前时间-天周:{}", DateUtil.dayOfWeekEnum(DateUtil.date()));
        log.info("当前时间-周末:{}", DateUtil.isWeekend(DateUtil.date()));
        log.info("当前时间-小时:{}", DateUtil.hour(DateUtil.date(),true));
        log.info("当前时间-分钟:{}", DateUtil.minute(DateUtil.date()));
        log.info("当前时间-秒:{}", DateUtil.second(DateUtil.date()));
        log.info("当前时间-毫秒:{}", DateUtil.millisecond(DateUtil.date()));
        log.info("当前时间-上午:{}", DateUtil.isAM(DateUtil.date()));
        log.info("当前时间-上午:{}", DateUtil.isPM(DateUtil.date()));
        log.info("当前时间-今年:{}", DateUtil.thisYear());
        log.info("当前时间-今月:{}", DateUtil.thisMonth());
        log.info("当前时间-今月:{}", DateUtil.thisMonthEnum());
        log.info("获取某年的开始时间:{}", DateUtil.beginOfYear(DateUtil.date()));
        log.info("获取某年的结束时间:{}", DateUtil.endOfYear(DateUtil.date()));
        log.info("当前日期所在年份的第几周:{}", DateUtil.thisWeekOfYear());
        log.info("当前日期所在月份的第几周:{}", DateUtil.thisWeekOfMonth());
        log.info("当前日期是这个日期所在月份的第几天:{}", DateUtil.thisDayOfMonth());
        log.info("中文时间:{}", DateUtil.formatChineseDate(DateUtil.date(), true, true));
        log.info("中文时间:{}", DateUtil.formatChineseDate(DateUtil.date(), false, true));
        log.info("星座：{}", DateUtil.getZodiac(2, 11));
        log.info("生肖：{}", DateUtil.getChineseZodiac(2023));
        log.info("生肖：{}", DateUtil.getChineseZodiac(1991));
        log.info("生肖：{}", DateUtil.getChineseZodiac(1990));
        log.info("本月的最后一天：{}", DateUtil.getLastDayOfMonth(DateUtil.date()));
        List<DateTime> list = DateUtil.rangeToList(DateUtil.parse("2023-01-01"),DateUtil.date(), DateField.MONTH);
        List<String> newList = new ArrayList<String>();
        for (DateTime dateTime : list) {

            newList.add(DateUtil.format(dateTime, DatePattern.NORM_DATE_PATTERN));
        }
        log.info("时间段：{}", JSON.toJSONString(newList));

        List<String> stringList = DateUtil.rangeFunc(DateUtil.beginOfYear(DateUtil.date()), DateUtil.date(), DateField.MONTH,  d -> DateUtil.format(d, DatePattern.NORM_DATETIME_PATTERN));
        log.info("时间段：{}", JSON.toJSONString(stringList));


        Map<Date, String> map = new HashMap<Date, String>();
        map.put(DateUtil.date().offset(DateField.HOUR, 4), "444444");
        map.put(DateUtil.date(), "111111");
        map.put(DateUtil.date().offset(DateField.HOUR, 2), "222222");
        map.put(DateUtil.date().offset(DateField.HOUR, 3), "3333333");
        List<Map.Entry<Date, String>> listKey = new ArrayList<>(map.entrySet());
        log.info("排序前：{}", JSON.toJSONString(listKey));
        listKey = listKey.stream().sorted((o1,o2) -> DateUtil.compare(o2.getKey(), o1.getKey())).collect(Collectors.toList());
        log.info("排序后：{}", JSON.toJSONString(listKey));
    }




}
