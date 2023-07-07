package com.test.learn.oauth2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author smj
 * @Title: oauth2
 * @ProjectName learnGit
 * @packageName com.test.learn.oauth2
 * @date 2023/7/6 15:13
 */

@Slf4j
public class oauth2 {



    @Test
    void test1(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info("112233 BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("112233"));
        log.info("112233 BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("112233"));
        log.info("book BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("book"));
        log.info("smj BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("smj"));

    }
}
