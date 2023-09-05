package com.test.learn.utils.hutool;

import cn.hutool.core.lang.Dict;
import cn.hutool.extra.expression.ExpressionEngine;
import cn.hutool.extra.expression.ExpressionUtil;
import cn.hutool.extra.expression.engine.jexl.JexlEngine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: ExpressionUtilTest
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.hutool
 * @date 2023/9/5 13:39
 */

@Slf4j
public class ExpressionUtilTest {
    public static void main(String[] args) {
        final Dict dict = Dict.create()
                .set("a", 100.3)
                .set("b", 45)
                .set("c", -199.100);

        // -143.8
        final Object eval = ExpressionUtil.eval("a-(b-c)", dict);
        log.info("eval: {}" , eval);

        // 自定义引擎执行



    }
}
