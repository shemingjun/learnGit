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
@KeySequence("user_db.SEQ_t_user_role")
@TableName(value="t_user_role",schema = "user_db")
public class TUserRole extends Model<TUserRole> {

    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "不能为空")
    @TableField(value = "user_id")
    @ExcelProperty(value = "")
    private Long userId;

    @NotEmpty(message = "不能为空")
    @TableField(value = "role_id")
    @ExcelProperty(value = "")
    private Long roleId;

    @TableField(value = "create_time")
    @ExcelProperty(value = "")
    private LocalDateTime createTime;

    @TableField(value = "creator")
    @ExcelProperty(value = "")
    private String creator;


}
