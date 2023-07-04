package com.test.learn.utils.hutool;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * @author smj
 * @Title: learn03
 * @ProjectName learnGit
 * @date 2023/2/8 13:33
 */
@Slf4j
public class learnHutool03 {
    public static void main(String[] args) {
        log.info("反转字符串:{}", StrUtil.reverse("15026672711"));
        log.info("反转字符串:{}", StrUtil.reverse("learnGit"));
    }




}
