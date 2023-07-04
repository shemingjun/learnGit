package com.test.learn.utils;

import cn.hutool.core.util.StrUtil;

/**
 * @author smj
 * @Title: SqlUtil
 * @ProjectName learnGit
 * @packageName com.test.learn.utils
 * @date 2023/7/4 15:16
 */

public class SqlUtil {
    /**
     * 定义常用的 sql关键字
     */
    public static String SQL_REGEX = "select |insert |delete |update |drop |count |exec |chr |mid |master |truncate |char |and |declare ";

    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value) {
        if (StrUtils.isNotEmpty(value) && !isValidOrderBySql(value)) {
            throw new RuntimeException("参数不符合规范，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }

    /**
     * SQL关键字检查
     */
    public static void filterKeyword(String value) {
        if (StrUtils.isEmpty(value)) {
            return;
        }
        String[] sqlKeywords = StrUtil.split(SQL_REGEX, "\\|").toArray(new String[0]);
        for (String sqlKeyword : sqlKeywords) {
            if (StrUtil.indexOfIgnoreCase(value, sqlKeyword) > -1) {
                throw new RuntimeException("参数存在SQL注入风险");
            }
        }
    }
}
