package com.yutu.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName:StartupRunner
 * @Author:zhaobc
 * @Date:2019/4/17
 * @Description:
 **/
@Component
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        try {
            // 读取config配置文件，并赋值到ConfigConstants常量类静态属性中  可以进行加密处理
            Properties properties = PropertiesLoaderUtils.loadAllProperties("config/web.properties");
            //获取业务配置文件区域
            //ConfigConstants.Home_Page=properties.getProperty("Home_Page");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("==========================> 系统加载配置文件缓存执行完成 ---------------------");
    }
}
