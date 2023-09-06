package com.test.learn.mail;

import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: mailTest01
 * @ProjectName learnGit
 * @packageName com.test.learn.mail
 * @date 2023/9/6 12:00
 */

@Slf4j
public class mailTest01 {
    public static void main(String[] args) {
        MailUtil.send("Mingjun.She@luxsan-ict.com", "测试", "邮件来自Hutool测试", false);

    }
}
