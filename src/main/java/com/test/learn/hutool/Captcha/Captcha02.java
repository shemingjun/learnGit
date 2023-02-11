package com.test.learn.hutool.Captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

/**
 * @author smj
 * @Title: Captcha02
 * @ProjectName learnGit
 * @packageNamecom.test.learn.hutool.Captcha
 * @date 2023/2/11 11:16
 */
@Slf4j
public class Captcha02 {
    public static void main(String[] args) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 70, 4, 15);
        lineCaptcha.setBackground(Color.yellow);
        lineCaptcha.write("D:/test/captcha/tellow.png");


//        String codeResponse = HttpRequest.post("http://www.bhshare.cn/imgcode/")
//                .form("token","0da353ad3")
//                .form("type","local")
//                .form("file",new File("D:/test/captcha/tellow.png"))
//                .execute().body();
//        log.info("codeResponse：{}", codeResponse);

    }
}
