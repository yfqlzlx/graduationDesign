package org.yf.manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author yfqlzlx
 * @date 2019/4/8 16:10
 *
 * springmvc的静态资源映射
 */
@Configuration
public class SpringmvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 工程静态文件映射
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // 本地图片映射
        registry.addResourceHandler("/api/goods/img/**").addResourceLocations("file:D:/素材/gd/");
    }
}
