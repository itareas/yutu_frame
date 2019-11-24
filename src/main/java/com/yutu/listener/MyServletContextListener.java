package com.yutu.listener;

import com.alibaba.fastjson.JSON;
import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.Blacklist;
import com.yutu.entity.ClientVisiting;
import com.yutu.entity.ConfigConstants;
import com.yutu.util.BlacklistUitls;
import com.yutu.util.StreamUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: MyServletContextListener
 * @Author: zhaobc
 * @Date: 2019/6/1 15:55
 * @Description:
 **/
@WebListener
public class MyServletContextListener implements ServletContextListener {
    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 12:15
     * @Description: 注入容器初始化web.xml中配置的servlet
     **/
    @Resource
    WebApplicationContext applicationContext;


    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 16:01
     * @Description: 项目起始时候加载 反序列化
     **/
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //起始加载配置文件
        startupRunnerConfig();
        //项目启动进行反序列化黑名单
        getDeserialize();
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 16:01
     * @Description: 项目关闭时候加载 序列号
     **/
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //项目关闭时候进行序列化黑名单
        getSerialize();
    }

    /**
     *@Author: zhaobc
     *@Date: 2019/6/21 9:45
     *@Description: 系统启动时加载的文件
     **/
    public void startupRunnerConfig() {
        SystemPropertiesConfig.System_Register_Request = getRegisterUrl();
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 12:16
     * @Description: 获得系统所有注入的地址
     **/
    public List<String> getRegisterUrl() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        List<String> urlList = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            String controllerName = entry.getValue().getBean().toString();
            //判断一下，前台加载页面不算
            if (!controllerName.equals("redirectController")) {
                //获得地址集合
                Set<String> patterns = entry.getKey().getPatternsCondition().getPatterns();
                for (String url : patterns) {
                    urlList.add(url);
                }
            }
        }
        return urlList;
    }



    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 17:09
     * @Description: 进行序列化操作
     **/
    public void getSerialize() {
        try {
            //获取给定的文件在服务器上面的绝对路径。   springboot 无法使用ServletContext 路径
            // String path = context.getRealPath(ConfigConstants.System_BlacklistPath);
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "config/Black/";
            //判断路径是否存在，不存在创建
            File fileDir = new File(path);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            //序列话黑名单
            StreamUtils.<Blacklist>writeObject(BlacklistUitls.blacklist, new File(path + "blacklist.zbc"));
        } catch (Exception e) {
            System.out.print("==============>序列化失败：" + e.getMessage());
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 17:09
     * @Description: 进行反序列化
     **/
    public void getDeserialize() {
        try {
            //获取给定的文件在服务器上面的绝对路径。 springboot 无法使用ServletContext 路径
            //String path = context.getRealPath(ConfigConstants.System_BlacklistPath);
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() +  "config/Black/";
            //判断路径是否存在，不存在创建
            File fileDir = new File(path);
            if (!fileDir.exists()) {
                //新建路径
                fileDir.mkdirs();
                //读取文件列表
                List<Blacklist> black = StreamUtils.<Blacklist>readObjectForList(new File(path + "blacklist.zbc"));
                //判断是否为null
                if (black != null) {
                    BlacklistUitls.blacklist.addAll(black);
                }
            }
        } catch (Exception e) {
            System.out.print("==============>反序列化失败：" + e.getMessage());
        }
    }


}
