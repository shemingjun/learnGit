package com.test.learn.oauth.service;

import com.test.learn.oauth.entity.OauthClientDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.learn.utils.AjaxResult;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
/**
 * <p>
 * 接入客户端信息 服务类
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
public interface IOauthClientDetailsService extends IService<OauthClientDetails> {

    /**
     * 保存接入客户端信息信息
     */
    AjaxResult saveOauthClientDetails(OauthClientDetails oauthClientDetails);

    /**
     * 修改接入客户端信息信息
     */
    AjaxResult updateOauthClientDetails(OauthClientDetails oauthClientDetails);

    /**
     * 导入接入客户端信息信息
     * @return 结果
     */
    String importExcel(MultipartFile file);

    /**
     * 导出接入客户端信息信息
     */
    void export(HttpServletResponse response, OauthClientDetails oauthClientDetails);
}
