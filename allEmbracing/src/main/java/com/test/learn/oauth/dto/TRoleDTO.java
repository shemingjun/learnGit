package com.test.learn.oauth.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class TRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ExcelProperty(value = "")
    private Long id;
    @ExcelProperty(value = "")
    private String roleName;
    @ExcelProperty(value = "")
    private String description;
    @ExcelProperty(value = "")
    private LocalDateTime createTime;
    @ExcelProperty(value = "")
    private LocalDateTime updateTime;
    @ExcelProperty(value = "")
    private String status;



}
