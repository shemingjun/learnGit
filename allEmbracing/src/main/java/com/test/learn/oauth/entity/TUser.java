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
@KeySequence("user_db.SEQ_t_user")
@TableName(value="t_user",schema = "user_db")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    @NotEmpty(message = "用户id不能为空")
    @TableField(value = "id")
    @ExcelProperty(value = "用户id")
    private Long id;

    @NotEmpty(message = "不能为空")
    @TableField(value = "username")
    @ExcelProperty(value = "")
    private String username;

    @NotEmpty(message = "不能为空")
    @TableField(value = "password")
    @ExcelProperty(value = "")
    private String password;

    /**
     * 用户姓名
     */
    @NotEmpty(message = "用户姓名不能为空")
    @TableField(value = "fullname")
    @ExcelProperty(value = "用户姓名")
    private String fullname;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @ExcelProperty(value = "手机号")
    private String mobile;


}
