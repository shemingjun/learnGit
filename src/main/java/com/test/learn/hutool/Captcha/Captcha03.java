package com.test.learn.hutool.Captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: Captcha03
 * @ProjectName learnGit
 * @packageName com.test.learn.hutool.Captcha
 * @date 2023/2/11 11:25
 */
@Slf4j
public class Captcha03 {
    public static void main(String[] args) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.write("D:/test/captcha/line.png");

        lineCaptcha.createCode();
        lineCaptcha.write("D:/test/captcha/line2.png");
    }
}
