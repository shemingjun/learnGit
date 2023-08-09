package com.test.learn.oauth.service;

import com.test.learn.oauth.entity.TPermission;
import com.test.learn.utils.AjaxResult;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface ITPermissionService extends IService<TPermission> {

    /**
     * 保存信息
     */
    int saveTPermission(TPermission tPermission);

    /**
     * 修改信息
     */
    AjaxResult updateTPermission(TPermission tPermission);

    /**
     * 导入信息
     * @return 结果
     */
    String importExcel(MultipartFile file);

    /**
     * 导出信息
     */
    void export(HttpServletResponse response, TPermission tPermission);
}
