package com.test.learn.hutool.Cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.impl.LRUCache;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: Cache02
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.Cache
 * @date 2023/2/11 14:42
 */
@Slf4j
public class Cache02 {
    public static void main(String[] args) {
        {
            int threadCount = 40000;
            final Cache<String, String> cache = new LRUCache<>(1000);

            for (int i = 0; i < threadCount; i++) {
                final int index = i;
                ThreadUtil.execute(() -> {
                    cache.put("key1"+ index, "value1");
                    cache.put("key2"+ index, "value2", System.currentTimeMillis() * 3);

                    int size = cache.size();
                    int capacity = cache.capacity();
                    if(size > capacity) {
                        log.info("{} {}", size, capacity);
                    }
                    ThreadUtil.sleep(1000);
                    size = cache.size();
                    capacity = cache.capacity();
                    if(size > capacity) {
                        log.info("## {} {}", size, capacity);
                    }
                });
            }

            ThreadUtil.sleep(5000);
        }
    }
}
