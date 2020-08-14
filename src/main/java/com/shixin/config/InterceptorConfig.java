package com.shixin.config;

import com.shixin.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 今何许
 * @date 2020-08-14 14:47
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截test
        registry.addInterceptor(new JwtInterceptor())
                //放行login
                .addPathPatterns("/user/test").excludePathPatterns("/user/login");
    }
}
