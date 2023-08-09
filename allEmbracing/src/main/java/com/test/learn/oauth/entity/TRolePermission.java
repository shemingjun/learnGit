package com.test.learn.oauth.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@KeySequence("user_db.SEQ_t_role_permission")
@TableName(value="t_role_permission",schema = "user_db")
public class TRolePermission extends Model<TRolePermission> {

    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "不能为空")
    @TableField(value = "role_id")
    @ExcelProperty(value = "")
    private Long roleId;

    @NotEmpty(message = "不能为空")
    @TableField(value = "permission_id")
    @ExcelProperty(value = "")
    private Long permissionId;


}
