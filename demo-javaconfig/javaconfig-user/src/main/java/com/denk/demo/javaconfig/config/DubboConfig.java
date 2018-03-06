package com.denk.demo.javaconfig.config;

import com.alibaba.dubbo.config.*;
import com.denk.demo.base.iface.IUser;
import com.denk.demo.javaconfig.service.UserService;
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
    public ServiceConfig<IUser> service(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                        ProtocolConfig protocolConfig, MonitorConfig monitorConfig) {
        IUser userService = new UserService();
        ServiceConfig<IUser> serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setMonitor(monitorConfig);
        serviceConfig.setInterface(IUser.class);
        serviceConfig.setRef(userService);
        serviceConfig.setTimeout(5000);
        serviceConfig.export();
        return serviceConfig;
    }
}
