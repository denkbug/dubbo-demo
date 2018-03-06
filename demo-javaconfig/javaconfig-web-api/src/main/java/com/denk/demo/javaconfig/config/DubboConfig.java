package com.denk.demo.javaconfig.config;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.denk.demo.base.iface.IUser;
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
        applicationConfig.setName("javaconfig-web-api");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    @Bean
    public ReferenceConfig<IUser> referenceConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                                  MonitorConfig monitorConfig) {
        ReferenceConfig<IUser> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setMonitor(monitorConfig);
        referenceConfig.setInterface(IUser.class);
        referenceConfig.setTimeout(5000);
        referenceConfig.setRetries(0);
        return referenceConfig;
    }

    @Bean
    public ReferenceConfigCache referenceConfigCache() {
        ReferenceConfigCache referenceConfigCache = ReferenceConfigCache.getCache();
        return referenceConfigCache;
    }

    @Bean
    public IUser userService(ReferenceConfigCache referenceConfigCache, ReferenceConfig<IUser> referenceConfig) {
        return referenceConfigCache.get(referenceConfig);
    }

}
