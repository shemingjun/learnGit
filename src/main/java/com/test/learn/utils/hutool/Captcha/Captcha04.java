package com.test.learn.utils.hutool.Captcha;

import cn.hutool.captcha.*;
import cn.hutool.captcha.generator.MathGenerator;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

/**
 * @author smj
 * @Title: Captcha04
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.hutool.Captcha
 * @date 2023/2/11 11:31
 */
@Slf4j
public class Captcha04 {
    public static void main(String[] args) {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
//        CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        captcha.write("D:/test/captcha/circle.png");

        ShearCaptcha captcha1 = CaptchaUtil.createShearCaptcha(203, 100, 4, 4);
        captcha1.write("D:/test/captcha/shear.png");



        ShearCaptcha captcha2 = new ShearCaptcha(200, 100, 4, 4);
        captcha2.write("d:/test/captcha/shear2.png");

        ShearCaptcha captcha3 = CaptchaUtil.createShearCaptcha(400, 100, 4, 4);
        captcha3.setGenerator(new MathGenerator());
        captcha3.write("D:/test/captcha/shear_math.png");


        GifCaptcha captcha4 = CaptchaUtil.createGifCaptcha(200, 100, 4);
        captcha4.write("d:/test/captcha/gif_captcha.gif");
//                        String codeResponse = HttpRequest.post("http://www.bhshare.cn/imgcode/")
//                .form("token","0da353ad3")
//                .form("type","local")
//                .form("file",new File("D:/test/captcha/gif_captcha.gif"))
//                .execute().body();
//        log.info("codeResponse：{}", codeResponse);


        LineCaptcha captcha5 = CaptchaUtil.createLineCaptcha(200, 100, 4, 1);
        captcha5.setBackground(Color.WHITE);
        captcha5.write("d:/test/captcha/test.jpg");

    }
}
