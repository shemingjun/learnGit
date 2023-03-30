package com.test.learn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.test.learn.entity.Pareson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smj
 * @Title: demo01
 * @ProjectName learnGit
 * @packageName com.test.learn.controller
 * @date 2023/2/24 10:02
 */
@Slf4j
@RestController
public class demo01 {
    @PostMapping("/list")
    public JSONObject s(@RequestBody JSONObject param){
        log.info("{}",param);
        return param;
    }


    @PostMapping("/list1")
    public Pareson s1(Pareson param){
        log.info("{}",param);
        return param;
    }

    @PostMapping("/list3")
    public Pareson s3(@RequestBody Pareson param){
        log.info("{}",param);
        return param;
    }
}
