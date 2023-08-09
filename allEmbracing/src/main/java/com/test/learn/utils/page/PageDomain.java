package com.test.learn.utils.page;

import cn.hutool.core.util.StrUtil;
import com.test.learn.utils.StrUtils;
import lombok.Getter;

/**
 * @author smj
 * @Title: PageDomain
 * @ProjectName learnGit
 * @packageName com.test.learn.utils.page
 * @date 2023/7/4 14:54
 */

public class PageDomain {
    /**
     * 当前记录起始索引
     */
    private Integer pageNum;

    /**
     * 每页显示记录数
     */
    private Integer pageSize;

    /**
     * 排序列
     */
    private String orderByColumn;

    /**
     * 排序的方向desc或者asc
     */
    private String isAsc = "asc";

    @Getter
    private Boolean asc = true;

    /**
     * 分页参数合理化
     */
    private Boolean reasonable = true;

    public String getOrderBy() {
        if (StrUtil.isEmpty(orderByColumn)) {
            return "";
        }
        return StrUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        if (StrUtil.isNotEmpty(isAsc)) {
            // 兼容前端排序类型
            if ("ascending".equals(isAsc)) {
                isAsc = "asc";
            } else if ("descending".equals(isAsc)) {
                isAsc = "desc";
                asc = false;
            }
            this.isAsc = isAsc;
        }
    }

    public Boolean getReasonable() {
            return Boolean.TRUE;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }
}
