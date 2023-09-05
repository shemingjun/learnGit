package com.test.learn;

import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.extra.pinyin.engine.pinyin4j.Pinyin4jEngine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: pinyinUtilTest
 * @ProjectName learnGit
 * @packageName com.test.learn
 * @date 2023/9/5 13:18
 */

@Slf4j
public class pinyinUtilTest {
    public static void main(String[] args) {
        // 获取拼音
        String pinyin = PinyinUtil.getPinyin("你好", " ");
        log.info("Pinyin:{}", pinyin);

        // 获取拼音首字母
        String result = PinyinUtil.getFirstLetter("H是第一个", ", ");
        log.info("result:{}", result);

        // 自定义拼音库（拼音引擎）
        Pinyin4jEngine engine = new Pinyin4jEngine();
        String pinyin2 = engine.getPinyin("上海-长宁区", " ");
        log.info("Pinyin2:{}", pinyin2);
    }
}
