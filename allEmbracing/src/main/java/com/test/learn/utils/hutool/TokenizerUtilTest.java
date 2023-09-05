package com.test.learn.utils.hutool;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.extra.tokenizer.engine.hanlp.HanLPEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

/**
 * @author smj
 * @Title: TokenizerUtilTest
 * @ProjectName learnGit
 * @packageName com.test.learn
 * @date 2023/9/4 16:51
 *
 *  Hutool同时会通过TokenizerFactory根据用户引入的分词库的jar来自动选择用哪个库实现分词。
 */

@Slf4j
public class TokenizerUtilTest {
    public static void main(String[] args) {
        one();
    }

    private static void one() {
        //自动根据用户引入的分词库的jar来自动选择使用的引擎
        TokenizerEngine engine = TokenizerUtil.createEngine();

        // 以HanLP为例 自定义模板引擎
//        TokenizerEngine engine = new HanLPEngine();
        //解析文本
        String text = "这两个方法的区别在于返回值";
        Result result = engine.parse(text);
        //输出：这 两个 方法 的 区别 在于 返回 值
        String resultStr = IterUtil.join((Iterator<Word>)result, " ");

        log.info("TokenizerEngine:{}", resultStr);
    }
}
