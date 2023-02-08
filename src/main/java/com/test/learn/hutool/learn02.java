package com.test.learn.hutool;

import cn.hutool.core.util.PhoneUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 75290637
 * @Title: learn02
 * @ProjectName learnGit
 * @date 2023/2/8 10:44
 */

@Slf4j
public class learn02 {
    public static void main(String[] args) {
        log.info("中国内陆手机号:{}", PhoneUtil.isMobile("15026672711"));
        log.info("中国内陆手机号:{}", PhoneUtil.hideBetween("15026672711"));
        log.info("中国香港手机号:{}", PhoneUtil.isMobileHk("+85251004810"));
        log.info("中国手机号:{}", PhoneUtil.isPhone("+85251004810"));

    }
}
