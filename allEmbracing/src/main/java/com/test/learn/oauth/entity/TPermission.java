package com.test.learn.oauth.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.baomidou.mybatisplus.annotation.TableField;
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
@KeySequence("user_db.SEQ_t_permission")
@TableName(value="t_permission",schema = "user_db")
public class TPermission extends Model<TPermission> {

    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "不能为空")
    @TableField(value = "id")
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 权限标识符
     */
    @NotEmpty(message = "权限标识符不能为空")
    @TableField(value = "code")
    @ExcelProperty(value = "权限标识符")
    private String code;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ExcelProperty(value = "描述")
    private String description;

    /**
     * 请求地址
     */
    @TableField(value = "url")
    @ExcelProperty(value = "请求地址")
    private String url;


}
