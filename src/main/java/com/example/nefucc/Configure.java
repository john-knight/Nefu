package com.example.nefucc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class Configure  extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//      super.addViewControllers(registry);
        registry.addViewController("/teacher").setViewName("teacher");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/manager").setViewName("manager");

    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        Intercepeter拦截器拦截除（"/index","/login"）以外的所有请求
        registry.addInterceptor(new Intercepeter()).addPathPatterns("/**").excludePathPatterns("/index","/login");
    }
//         更改默认的静态资源位置(后来发现无需更改默认配置)
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}

