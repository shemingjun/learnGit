package com.test.learn.utils;

/**
 * @author smj
 * @Title: Constants
 * @ProjectName learnGit
 * @packageName com.test.learn.utils
 * @date 2023/7/4 15:54
 */

public class Constants {
    /**
     * 每个sheet默认写入行数
     *  最大 1048576 行
     */
    public static Integer SHEET_COUNT = 100000;
    /**
     * 每次写入数量
     */
    public static Integer SHEET_WRITE_NUM = 20000;

    /**
     * 每个文件sheet最大数量
     * 写满是 SHEET_COUNT*MAX_SHEET_NUM = 100w 的数据量
     * 超过该值后写成多个文件
     */
    public static Integer MAX_SHEET_NUM = 10;

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
}
