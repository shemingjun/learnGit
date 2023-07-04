package com.test.learn.oauth.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 
 *
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
@HeadFontStyle(fontHeightInPoints = 10)
@ExcelIgnoreUnannotated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    @ExcelProperty(value = "用户id")
    private Long id;
    @ExcelProperty(value = "")
    private String username;
    @ExcelProperty(value = "")
    private String password;
    /**
     * 用户姓名
     */
    @ExcelProperty(value = "用户姓名")
    private String fullname;
    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String mobile;



}
