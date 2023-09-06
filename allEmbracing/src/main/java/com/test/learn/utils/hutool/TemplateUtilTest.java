package com.test.learn.utils.hutool;

import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: TemplateUtilTest
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.hutool
 * @date 2023/9/6 8:59
 * 通过实现这两个接口，用户便可抛开模板实现，从而渲染模板。
 * Hutool同时会通过TemplateFactory根据用户引入的模板引擎库的jar来自动选择用哪个引擎来渲染。*
 */

@Slf4j
public class TemplateUtilTest {
    public static void main(String[] args) {
        //自动根据用户引入的模板引擎库的jar来自动选择使用的引擎
        //TemplateConfig为模板引擎的选项，可选内容有字符编码、模板路径、模板加载方式等，默认通过模板字符串渲染
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig());

        //假设我们引入的是Beetl引擎，则：
        Template template = engine.getTemplate("Hello ${name}");
        //Dict本质上为Map，此处可用Map
        String result = template.render(Dict.create().set("name", "Hutool"));
        //输出：Hello Hutool
        log.info("Hello ${name}:{}", result);
    }
}
