package com.test.learn.hutool.TimeInterval;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: demo01
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.TimeInterval
 * @date 2023/4/3 15:50
 */
@Slf4j
public class demo01 {
    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        ThreadUtil.sleep(2000);
        Console.log("TimeInterval:{}", timer.interval());
    }
}
