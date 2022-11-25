package com.fakebili.infrastructure.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zzl
 * @date 2022/11/24 09:52:26
 * @description sa-token 配置类
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                // 指定 拦截路由 与 放行路由
                .addInclude("/**").addExclude("/favicon.ico")

                // 认证函数: 每次请求执行
                .setAuth(obj -> {
                    // 登录认证 -- 拦截需要登录就才能用的路由, 判断是否登录过，没登录过⑨抛出异常
                    SaRouter.match("/**").notMatch("/api/v1/user/login", "/api/v1/user/register").check(StpUtil::checkLogin);
                })

                // 异常处理函数：每次认证函数发生异常时执行此函数
                .setError(e -> SaResult.error(e.getMessage()))

                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(r ->
                        // ---------- 设置一些安全响应头 ----------
                        SaHolder.getResponse()
                                // 服务器名称
                                .setServer("fakebili-final")
                                // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
                                .setHeader("X-Frame-Options", "SAMEORIGIN")
                                // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
                                .setHeader("X-XSS-Protection", "1; mode=block")
                                // 禁用浏览器内容嗅探
                                .setHeader("X-Content-Type-Options", "nosniff")
                                .setHeader("Access-Control-Allow-Origin", "*")
                                .setHeader("Access-Control-Allow-Headers", "*")
                );
    }
}