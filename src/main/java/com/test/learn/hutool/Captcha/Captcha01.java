package com.test.learn.hutool.Captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: Captcha01
 * @ProjectName learnGit
 * @packageNamecom.test.learn.hutool.Captcha
 * @date 2023/2/11 11:12
 */
@Slf4j
public class Captcha01 {
    public static void main(String[] args) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        log.info("code:{}", lineCaptcha.getCode());
        log.info("code:{}", lineCaptcha.verify(lineCaptcha.getCode()));
    }


}
