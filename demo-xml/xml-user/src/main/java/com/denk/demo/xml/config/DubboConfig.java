package com.denk.demo.xml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: denk
 * desc:
 * date: 2018/3/6
 */
@Configuration
@ImportResource("classpath:dubbo.xml")
public class DubboConfig {
}
