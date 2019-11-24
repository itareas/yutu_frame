package com.yutu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.DispatcherServlet;

//程序住入口
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//扫描拦截器的WebFilter的
@ServletComponentScan
public class YutuApplication {
    /**
     *@Author: zhaobc
     *@Date: 2019/4/19 14:57
     *@Description: 起始页
     **/
    public static void main(String[] args) {
        SpringApplication.run(YutuApplication.class, args);
    }

//    /**
//     *@Author: zhaobc
//     *@Date: 2019/5/29 15:42
//     *@Description: Tomcat启动配置   主类继承 extends SpringBootServletInitializer
//     **/
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(YutuApplication.class);
//    }
}