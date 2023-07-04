package com.test.learn.oauth.service;

import com.test.learn.oauth.entity.TRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.learn.utils.AjaxResult;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
public interface ITRolePermissionService extends IService<TRolePermission> {

    /**
     * 保存信息
     */
    int saveTRolePermission(TRolePermission tRolePermission);

    /**
     * 修改信息
     */
    AjaxResult updateTRolePermission(TRolePermission tRolePermission);

    /**
     * 导入信息
     * @return 结果
     */
    String importExcel(MultipartFile file);

    /**
     * 导出信息
     */
    void export(HttpServletResponse response, TRolePermission tRolePermission);
}
