package com.test.learn.sys;

import cn.hutool.system.*;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smj
 * @Title: SystemUtilTest
 * @ProjectName learnGit
 * @packageName com.test.learn.sys
 * @date 2023/9/6 18:57
 * 系统属性调用-SystemUtil
 *  https://doc.hutool.cn/pages/SystemUtil/#%E6%A6%82%E8%BF%B0
 */

@Slf4j
public class SystemUtilTest {
    public static void main(String[] args) {
        // Java Virtual Machine Specification信息
        JvmSpecInfo jvmSpecInfo = SystemUtil.getJvmSpecInfo();
        log.info("JvmSpecInfo:{}", JSON.toJSONString(jvmSpecInfo));

        // Java Virtual Machine Implementation信息
        JvmInfo jvmInfo = SystemUtil.getJvmInfo();
        log.info("JvmInfo:{}", JSON.toJSONString(jvmInfo));

        // Java Specification信息
        JavaSpecInfo javaSpecInfo = SystemUtil.getJavaSpecInfo();
        log.info("JavaSpecInfo:{}", JSON.toJSONString(javaSpecInfo));

        // Java Implementation信息
        JavaInfo javaInfo = SystemUtil.getJavaInfo();
        log.info("JavaInfo:{}", JSON.toJSONString(javaInfo));

        // Java运行时信息
        JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
        log.info("JavaRuntimeInfo:{}", JSON.toJSONString(javaRuntimeInfo));

        // 系统信息
        OsInfo osInfo = SystemUtil.getOsInfo();
        log.info("OsInfo:{}", JSON.toJSONString(osInfo));

        // 用户信息
        UserInfo userInfo = SystemUtil.getUserInfo();
        log.info("UserInfo:{}", JSON.toJSONString(userInfo));

        // 当前主机网络地址信息
        HostInfo hostInfo = SystemUtil.getHostInfo();
        log.info("HostInfo:{}", JSON.toJSONString(hostInfo));

        //运行时信息，包括内存总大小、已用大小、可用大小等
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        log.info("RuntimeInfo:{}", JSON.toJSONString(runtimeInfo));

    }
}
