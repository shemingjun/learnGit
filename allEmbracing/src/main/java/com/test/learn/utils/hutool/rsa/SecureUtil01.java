package com.test.learn.utils.hutool.rsa;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: SecureUtil01
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.hutool.rsa
 * @date 2023/7/11 17:47
 */
@Slf4j
public class SecureUtil01 {
    public static void main(String[] args) {
        log.info("SecureUtil01:{}", SecureUtil.rsa());
        log.info("SecureUtil01:{}", SecureUtil.rsa().getPrivateKeyBase64());

    }
}
