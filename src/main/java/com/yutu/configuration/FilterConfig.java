package com.yutu.configuration;

import com.yutu.filter.MyFilter;
import com.yutu.filter.XssAndSqlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.expression.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: FilterConfig
 * @Author: zhaobc
 * @Date: 2019/6/15 20:10
 * @Description:过滤器配置类
 **/
@Configuration
public class FilterConfig {
    /**
     *@Author: zhaobc
     *@Date: 2019/6/15 20:27
     *@Description: 设定MyFilter的配置，用于判断用户是否登录状态    第二道防线
     **/
    @Bean
    public FilterRegistrationBean buildMyFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setName("myFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**
     *@Author: zhaobc
     *@Date: 2019/6/15 20:45
     *@Description: 设定Xss和Sql注入过滤器配置   第一道防线
     **/
    @Bean
    public FilterRegistrationBean buildXssAndSqlFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssAndSqlFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}
