package com.test.learn.hutool.TimeInterval;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;

/**
 * @author smj
 * @Title: demo02
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.TimeInterval
 * @date 2023/4/3 15:53
 */

public class demo02 {
    public static void main(String[] args) {
        final TimeInterval timer = new TimeInterval();

// 分组1
        timer.start("1");
        ThreadUtil.sleep(800);

// 分组2
        timer.start("2");
        ThreadUtil.sleep(900);

        Console.log("Timer 1 took {} ms", timer.intervalMs("1"));
        Console.log("Timer 2 took {} ms", timer.intervalMs("2"));
    }
}
