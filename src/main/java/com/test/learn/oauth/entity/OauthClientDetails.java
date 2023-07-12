package com.test.learn.oauth.entity;

import cn.hutool.core.date.DatePattern;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
/**
 * <p>
 * 接入客户端信息
 *
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
@ExcelIgnoreUnannotated
@HeadFontStyle(fontHeightInPoints = 10)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence("user_db.SEQ_oauth_client_details")
@TableName(value="oauth_client_details",schema = "user_db")
public class OauthClientDetails extends Model<OauthClientDetails> {

    private static final long serialVersionUID = 1L;
    /**
     * 客户端标	识
     */
    @NotEmpty(message = "客户端标	识不能为空")
    @TableField(value = "client_id")
    @ExcelProperty(value = "客户端标	识")
    private String clientId;

    /**
     * 接入资源列表
     */
    @TableField(value = "resource_ids")
    @ExcelProperty(value = "接入资源列表")
    private String resourceIds;

    /**
     * 客户端秘钥
     */
    @TableField(value = "client_secret")
    @ExcelProperty(value = "客户端秘钥")
    private String clientSecret;

    /**
     * 客户端秘钥
     */
    @TableField(value = "secret")
    @ExcelProperty(value = "客户端秘钥对外")
    private String secret;

    @TableField(value = "scope")
    @ExcelProperty(value = "")
    private String scope;

    @TableField(value = "authorized_grant_types")
    @ExcelProperty(value = "")
    private String authorizedGrantTypes;

    @TableField(value = "web_server_redirect_uri")
    @ExcelProperty(value = "")
    private String webServerRedirectUri;

    @TableField(value = "authorities")
    @ExcelProperty(value = "")
    private String authorities;

    @TableField(value = "access_token_validity")
    @ExcelProperty(value = "")
    private Integer accessTokenValidity;

    @TableField(value = "refresh_token_validity")
    @ExcelProperty(value = "")
    private Integer refreshTokenValidity;

    @TableField(value = "additional_information")
    @ExcelProperty(value = "")
    private String additionalInformation;

    @NotEmpty(message = "不能为空")
    @TableField(value = "create_time")
    @ExcelProperty(value = "")
    private LocalDateTime createTime;

    @TableField(value = "archived")
    @ExcelProperty(value = "")
    private Byte archived;

    @TableField(value = "trusted")
    @ExcelProperty(value = "")
    private Byte trusted;

    @TableField(value = "autoapprove")
    @ExcelProperty(value = "")
    private String autoapprove;


}
