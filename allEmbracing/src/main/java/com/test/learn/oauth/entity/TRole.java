package com.test.learn.oauth.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 
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
@KeySequence("user_db.SEQ_t_role")
@TableName(value="t_role",schema = "user_db")
public class TRole extends Model<TRole> {

    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "不能为空")
    @TableField(value = "id")
    @ExcelProperty(value = "")
    private Long id;

    @TableField(value = "role_name")
    @ExcelProperty(value = "")
    private String roleName;

    @TableField(value = "description")
    @ExcelProperty(value = "")
    private String description;

    @TableField(value = "create_time")
    @ExcelProperty(value = "")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    @ExcelProperty(value = "")
    private LocalDateTime updateTime;

    @NotEmpty(message = "不能为空")
    @TableField(value = "status")
    @ExcelProperty(value = "")
    private String status;


}
