package com.denk.demo.annotation.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: denk
 * desc:
 * date: 2018/3/6
 */
@Configuration
public class DubboConfig {
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("javaconfig-user");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.denk.demo.annotation.controller");
        return annotationBean;
    }
}
