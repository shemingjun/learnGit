package com.test.learn.config.mybatisPlus;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author smj
 * @Title: MyMetaObjectHandler
 * @date 2023/1/4 14:10
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "addDate", Date.class, DateUtil.date());
        this.strictUpdateFill(metaObject, "editDate", Date.class, DateUtil.date());
        this.strictInsertFill(metaObject, "delFlag", Long.class, 0L);
        try{
//            this.strictInsertFill(metaObject, "addBy", String.class, SecurityUtils.getLoginUser().getUsername());
//            this.strictUpdateFill(metaObject, "editBy", String.class, SecurityUtils.getLoginUser().getUsername());
        } catch (Exception e){
            this.strictInsertFill(metaObject, "addBy", String.class, "admin");
            this.strictUpdateFill(metaObject, "editBy", String.class, "admin");
        }
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *  更改为强制更新，即原数据有值，在修改时也会强制更改修改时间和修改人（需使用自动更新注解  fill = FieldFill.INSERT_UPDATE 或 fill = FieldFill.UPDATE）
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        this.strictUpdateFill(metaObject, "editDate", Date.class, DateUtil.date());
        this.setFieldValByName("editDate", DateUtil.date(), metaObject);
        try{
//            this.strictUpdateFill(metaObject, "editBy", String.class, SecurityUtils.getLoginUser().getUsername());
//            this.setFieldValByName("editBy", SecurityUtils.getLoginUser().getUsername(), metaObject);
        } catch (Exception e){
//            this.strictUpdateFill(metaObject, "editBy", String.class, "admin");
            this.setFieldValByName("editBy", "admin", metaObject);
        }
    }
}
