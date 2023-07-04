package com.test.learn.config.mybatisPlus;

import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 支持 * 匹配扫描包。
 *
 * @author ruoyi
 */
@Configuration
@MapperScan({"com.test.learn.mapper"})
public class MyBatisPlusConfig {

    /**
     * 分页插件
     * 攻击 SQL 阻断解析器,防止全表更新与删除
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    /**
     * ORACLE 序号ID生成器
     */
    @Bean
    public OracleKeyGenerator keyGenerator() {
        return new OracleKeyGenerator();
    }
}