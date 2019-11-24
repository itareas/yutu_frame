package com.yutu.util;

import com.alibaba.fastjson.JSON;
import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.Blacklist;
import com.yutu.entity.ClientVisiting;
import com.yutu.entity.ConfigConstants;
import com.yutu.exception.GlobalExceptionHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: BlacklistUitl
 * @Author: zhaobc
 * @Date: 2019/5/31 15:22
 * @Description:
 **/
public class BlacklistUitls {
    private final Logger logger = LogManager.getLogger(BlacklistUitls.class);

    /**
     * @Author: zhaobc
     * @Date: 2019/5/31 17:31
     * @Description: 日志信息存储
     **/
    private static HashMap<String, ClientVisiting> clientList = new HashMap<String, ClientVisiting>();

    /**
     * @Author: zhaobc
     * @Date: 2019/5/31 17:31
     * @Description: 黑名单信息
     **/
    public static List<Blacklist> blacklist = new ArrayList<>();


    /**
     * @Author: zhaobc
     * @Date: 2019/5/31 16:17
     * @Description: 判断此ip是否可以访问
     **/
    public boolean judgeBlacklist(HttpServletRequest request) {
        String strIp = request.getRemoteAddr();
        String strPath = request.getRequestURI();
        String strMethod = request.getMethod();

        //获得所有本机写的地址,并判断释放和地址栏中匹配；
        List<String> registerUrl = SystemPropertiesConfig.System_Register_Request.stream().filter(R -> strPath.trim().toLowerCase().contains(R.trim().toLowerCase())).collect(Collectors.toList());
        //先判断黑名单中是否存在此ip
        List<Blacklist> blacklistJudge = new ArrayList<>();
        if (blacklist.size() > 0) {
            blacklistJudge=blacklist.stream().filter(B -> B.getClientIP().equals(strIp)).collect(Collectors.toList());
        }

        //如果访问地址是系统接口和在黑名单中，禁止此人访问
        if (registerUrl.size() >= 1 && blacklistJudge.size()>0) {
            return false;
        }else if(registerUrl.size() < 1){
            //没有访问系统接口并且黑名单没有提前放行
            return true;
        }

        //给获取客户端信息
        ClientVisiting clent = new ClientVisiting();
        //判断现在此用户是否已经访问
        ClientVisiting clientNew = getClientVisiting(strIp);
        //判断访问次数
        if (clientNew != null) {
            //获得访问次数后加一
            int count = clientNew.getVisitCount();
            count+=1;
            clientNew.setVisitCount(count);
            clientNew.setVisitPath(strPath);
            clientNew.setVisitType(strMethod);
            clent=clientNew;
        } else {
            clent.setClientIP(strIp);
            clent.setVisitPath(strPath);
            clent.setVisitType(strMethod);
            clent.setVisitCount(1);
            clent.setVisitDate(new Date());
        }
        //把客户端信息添加到日志
        putClientVisiting(clent);
        return true;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/5/31 15:45
     * @Description: 获得访问客户端信息
     **/
    public ClientVisiting getClientVisiting(String strIp) {
        //判断日志资源是否存在此ip
        if (clientList.containsKey(strIp)) {
            return clientList.get(strIp);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/5/31 15:47
     * @Description: 添加来访信息
     **/
    public void putClientVisiting(ClientVisiting clientInfo) {
        // 判断一分钟访问的次数
        int maxCount = Integer.parseInt(SystemPropertiesConfig.System_Blacklist_MaxNumber);
        //获得现在时间
        Date now = new Date();
        long dateCount = now.getTime() - clientInfo.getVisitDate().getTime();
        //写日志
        logger.info("============>"+clientInfo.getVisitCount()+";-----------<>"+clientInfo.getClientIP()+";------------<>"+clientInfo.getVisitPath()+";------------<>"+clientInfo.getVisitDate()+";");
        // 如果访问次数大于10并且时间小于一分钟进行加入黑名单
        if (clientInfo.getVisitCount() >= maxCount && dateCount / (1000 * 60) <= 1) {
            Blacklist black = new Blacklist();
            black.setClientIP(clientInfo.getClientIP());
            black.setVisitDate(clientInfo.getVisitDate());
            black.setVisitPath(clientInfo.getVisitPath());
            black.setVisitType(clientInfo.getVisitType());
            blacklist.add(black);
            // 删除所有此ip下记录数据
            deleteSessionById(clientInfo.getClientIP());
            //加入黑名单后，不在存储此ip的访问信息，故返回
            return;
        } else if (dateCount / (1000 * 60) > 1) {
            // 如果访问间隔超过一分钟,清除历史数据
            deleteSessionById(clientInfo.getClientIP());
            //更改访问次数为1
            clientInfo.setVisitCount(1);
        }
        // 存储到集合里
        clientList.put(clientInfo.getClientIP(), clientInfo);
        return;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/5/31 16:59
     * @Description: 删除数据
     **/
    public void deleteSessionById(String strIp) {
        clientList.remove(strIp);
    }


}
