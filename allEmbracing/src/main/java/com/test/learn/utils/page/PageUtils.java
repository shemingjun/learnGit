package com.test.learn.utils.page;

import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.PageHelper;
import com.test.learn.utils.SqlUtil;

/**
 * @author smj
 * @Title: PageUtils
 * @ProjectName learnGit
 * @packageName com.test.learn.utils
 * @date 2023/7/4 14:53
 */

public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (ObjUtil.isNotNull(pageNum) && ObjUtil.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            Boolean reasonable = pageDomain.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }
    }
}
