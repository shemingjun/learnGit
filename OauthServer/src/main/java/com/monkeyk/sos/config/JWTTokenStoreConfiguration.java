package com.monkeyk.sos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import com.monkeyk.sos.service.UserService;

/**
 * 2020/6/9
 * <p>
 * <p>
 * JWT TokenStore config
 * <p>
 * 使用时配置参数
 * <pre>sos.token.store=jwt</pre>
 *
 * @author Shengzhao Li
 * @since 2.1.0
 */
@Configuration
@ConditionalOnProperty(name = "sos.token.store", havingValue = "jwt")
public class JWTTokenStoreConfiguration {


    /**
     * 不同的系统用不同的jwtKey；不推荐共用一样的
     * <p>
     * HMAC key, default: IH6S2dhCEMwGr7uE4fBakSuDh9SoIrRa
     * alg: HMACSHA256
     */
    @Value("${sos.token.store.jwt.key:IH6S2dhCEMwGr7uE4fBakSuDh9SoIrRa}")
    private String jwtKey;

    /**
     * 是否重复使用已经有的 refresh_token 直到过期，默认true
     *
     * @since 2.1.0
     */
    @Value("${sos.reuse.refresh-token:true}")
    private boolean reuseRefreshToken;


    @Bean
    public JwtAccessTokenConverter accessTokenConverter(UserService userService) {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();

        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
        userAuthenticationConverter.setUserDetailsService(userService);
//        userAuthenticationConverter.setDefaultAuthorities(new String[]{"USER"});
        tokenConverter.setUserTokenConverter(userAuthenticationConverter);

        tokenConverter.setIncludeGrantType(true);
//        tokenConverter.setScopeAttribute("_scope");
        jwtAccessTokenConverter.setAccessTokenConverter(tokenConverter);

        jwtAccessTokenConverter.setSigningKey(this.jwtKey);
        return jwtAccessTokenConverter;
    }

    /**
     * JWT TokenStore
     *
     * @since 2.1.0
     */
    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }


    @Bean
    public DefaultTokenServices tokenServices(TokenStore tokenStore, JwtAccessTokenConverter tokenEnhancer, ClientDetailsService clientDetailsService) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setClientDetailsService(clientDetailsService);
        //support refresh token
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenEnhancer(tokenEnhancer);
        tokenServices.setReuseRefreshToken(this.reuseRefreshToken);
        return tokenServices;
    }

}
