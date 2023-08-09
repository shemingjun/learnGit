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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        log.info("112233 BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7EvOqhO0oMxFz+ich+XDeDDvY2VKWUnQNFner5/51CcgqOD2BILEC6Oxmeyvn8sRlEvgKSVtFL5I7uwNjcW6WrBmsDuhP6gHCgKdo0YNFEsvHxVqH7GnG34uwC3yJng8TND75Tu3Q/P/Q3c8OUh2AmiQi8wJ8uyg/+scLIEK0CQIDAQAB"));
        log.info("112233 BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("$2a$10$aS5vr3cb54H6mYAYce0bLeVQdv54Y2XwMGx3BWlDSodqSLetgNrxi"));
        log.info("book BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("112233"));
        log.info("smj BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("$2a$10$Y5w/9PJFEiGgZbPMTuitqeNu3hroZcGRk9KxTNTzcvnu5wZq011sC"));
        log.info("smj BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("$2a$08$1oZmlN50GkSBQIAy/RK6mO6aG76ANU5cCGkM9bWsiSIVC6UAQYxRC"));
        log.info("smj BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("$2a$10$oAn/751b5vhOMnL6nbPPpOaC31BdcYhtoP7Ru4lqhZ7hkdgSLMPcK"));
        log.info("smj BCryptPasswordEncoder:{}",bCryptPasswordEncoder.encode("$2a$10$EmrM4sWgCGNLNihriHPKBOe9dMHaJYKORKTGDVxSOa.ViYd.NUg96"));

    }
}
