package com.test.learn.oauth.mapper;

import com.test.learn.oauth.entity.OauthClientDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 接入客户端信息 Mapper 接口
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
@Repository
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {

}
