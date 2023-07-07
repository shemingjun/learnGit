package com.test.learn.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author smj
 * @Title: ResourceServerConfig
 * @ProjectName learnGit
 * @packageName com.test.learn.config.oauth2
 * @date 2023/7/7 11:00
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationManager(new OAuth2AuthenticationManager());
        resources.resourceId("all").tokenStore(tokenStore).stateless(true);
    }


}
