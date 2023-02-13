package com.test.learn.hutool.Cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: Cache01
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.Cache
 * @date 2023/2/11 13:55
 */
@Slf4j
public class Cache01 {
    public static void main(String[] args) {
        int threadCount = 4000;
        final Cache<String, String> cache = new FIFOCache<>(3);

        // 由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除

        for (int i = 0; i < threadCount; i++) {
            ThreadUtil.execute(() -> {
                cache.put("key1", "value1", System.currentTimeMillis() * 3);
                cache.put("key2", "value2", System.currentTimeMillis() * 3);
                cache.put("key3", "value3", System.currentTimeMillis() * 3);
                cache.put("key4", "value4", System.currentTimeMillis() * 3);
                ThreadUtil.sleep(1000);
                cache.put("key5", "value5", System.currentTimeMillis() * 3);
                cache.put("key6", "value6", System.currentTimeMillis() * 3);
                cache.put("key7", "value7", System.currentTimeMillis() * 3);
                cache.put("key8", "value8", System.currentTimeMillis() * 3);
                Console.log("put all");
            });
        }

        for (int i = 0; i < threadCount; i++) {
            ThreadUtil.execute(() -> show(cache));
        }

        System.out.println("==============================");
        ThreadUtil.sleep(10000);
    }



    private static void show(Cache<String, String> cache) {

        for (Object tt : cache) {
            Console.log(tt);
        }
    }
}
