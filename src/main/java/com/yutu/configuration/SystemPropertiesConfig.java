package com.yutu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 *@Author: zhaobc
 *@Date: 2019/6/21 9:55
 *@Description: 系统核心配置文件
 **/
@Configuration
public class SystemPropertiesConfig {
    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 是否启用拦截器
     **/
    public static String System_Interceptor_StartUp;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 拦截器超时时间
     **/
    public static String System_Interceptor_OverTime;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 15:40
     * @Description: 是否启动黑名单机制
     **/
    public static String System_Blacklist_StartUp;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 15:40
     * @Description: 一分钟最多访问次数
     **/
    public static String System_Blacklist_MaxNumber;


    /**
     * @Author: zhaobc
     * @Date: 2019/6/15 21:15
     * @Description: 是否启动Xss和Sql过滤
     **/
    public static String System_XssAndSql_StartUp;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 过滤器放行的路径
     **/
    public static String System_Filter_Path;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 系统首页
     **/
    public static String System_Home_Page;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 系统登陆页
     **/
    public static String System_Login_Page;


    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: redis服务器的IP地址
     **/
    public static String System_Redis_Host;
    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: redis的默认端口
     **/
    public static String System_Redis_Port;
    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: redis密码
     **/
    public static String System_Redis_PassWord;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 11:51
     * @Description: 系统内部所有注册的请求地址
     **/
    public static List<String> System_Register_Request;


    @Value("${System.Interceptor.StartUp}")
    public void setSystem_Interceptor_StartUp(String system_Interceptor_StartUp) {
        System_Interceptor_StartUp = system_Interceptor_StartUp;
    }

    @Value("${System.Interceptor.OverTime}")
    public void setSystem_Interceptor_OverTime(String system_Interceptor_OverTime) {
        System_Interceptor_OverTime = system_Interceptor_OverTime;
    }

    @Value("${System.Blacklist.StartUp}")
    public void setSystem_Blacklist_StartUp(String system_Blacklist_StartUp) {
        System_Blacklist_StartUp = system_Blacklist_StartUp;
    }

    @Value("${System.Blacklist.MaxNumber}")
    public void setSystem_Blacklist_MaxNumber(String system_Blacklist_MaxNumber) {
        System_Blacklist_MaxNumber = system_Blacklist_MaxNumber;
    }

    @Value("${System.XssAndSql.StartUp}")
    public void setSystem_XssAndSql_StartUp(String system_XssAndSql_StartUp) {
        System_XssAndSql_StartUp = system_XssAndSql_StartUp;
    }

    @Value("${System.Filter.Path}")
    public void setSystem_Filter_Path(String system_Filter_Path) {
        System_Filter_Path = system_Filter_Path;
    }

    @Value("${System.Home.Page}")
    public void setSystem_Home_Page(String system_Home_Page) {
        System_Home_Page = system_Home_Page;
    }

    @Value("${System.Login.Page}")
    public void setSystem_Login_Page(String system_Login_Page) {
        System_Login_Page = system_Login_Page;
    }

    @Value("${System.Redis.Host}")
    public void setSystem_Redis_Host(String system_Redis_Host) {
        System_Redis_Host = system_Redis_Host;
    }

    @Value("${System.Redis.Port}")
    public void setSystem_Redis_Port(String system_Redis_Port) {
        System_Redis_Port = system_Redis_Port;
    }

    @Value("${System.Redis.PassWord}")
    public void setSystem_Redis_PassWord(String system_Redis_PassWord) {
        System_Redis_PassWord = system_Redis_PassWord;
    }


}
