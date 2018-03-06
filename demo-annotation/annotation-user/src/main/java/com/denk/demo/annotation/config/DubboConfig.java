package com.denk.demo.annotation.config;

import com.alibaba.dubbo.config.*;
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
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        //protocolConfig.setPort(20880);//dubbo 默认端口是20880，设置为-1或者不设置则会分配一个没有被占用的端口
        return protocolConfig;
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.denk.demo.annotation.service");
        return annotationBean;
    }
}
