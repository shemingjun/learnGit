package com.test.learn.oauth.service;

import com.test.learn.oauth.entity.TUserRole;
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
public interface ITUserRoleService extends IService<TUserRole> {

    /**
     * 保存信息
     */
    int saveTUserRole(TUserRole tUserRole);

    /**
     * 修改信息
     */
    AjaxResult updateTUserRole(TUserRole tUserRole);

    /**
     * 导入信息
     * @return 结果
     */
    String importExcel(MultipartFile file);

    /**
     * 导出信息
     */
    void export(HttpServletResponse response, TUserRole tUserRole);
}
