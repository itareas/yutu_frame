package com.yutu.listener;

import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TSysLandinglog;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.UUID;

/**
 * @ClassName: MyHttpSessionListener
 * @Author: zhaobc
 * @Date: 2019/4/19
 * @Description: 监听器，主要是监听用户登录，退出和在线人数等信息
 **/
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    /**
     *@Author: zhaobc
     *@Date: 2019/4/19
     *@Description: 创建会话的通知
     **/
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //System.out.println("创建session");
    }

    /**
     *@Author: zhaobc
     *@Date: 2019/4/19
     *@Description: 会话即将失效的通知
     **/
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //System.out.println("销毁session");
    }

}
