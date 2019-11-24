package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TSysLandinglog;
import com.yutu.entity.table.TSysUserinfo;
import com.yutu.mapper.mysql.TSysLandinglogMapper;
import com.yutu.mapper.mysql.TSysUserinfoMapper;
import com.yutu.service.ILoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName:LoginServiceImpl
 * @Author:zhaobc
 * @Date:2019/4/16 11:56
 * @Description:登录服务实现层
 **/
@Service
public class LoginServiceImpl implements ILoginService {
    @Resource
    private TSysUserinfoMapper sysUserinfoMapper;
    @Resource
    private TSysLandinglogMapper sysLandinglogMapper;

    @Override
    public MsgPack getLoginVerification(HttpServletRequest request, String userName, String userPwd) {
        MsgPack msgPack = new MsgPack();

        //给密码md5加密
        userPwd = DigestUtils.md5Hex(userPwd + "yutu&123");
        TSysUserinfo userInfo = sysUserinfoMapper.getLoginVerification(userName, userPwd);

        //获得客户端身份信息便于验证
        String address = request.getServletPath();
        String ip = request.getRemoteAddr();
        // sesson中存储客户端标识字段，需要进行验证是否是登陆着
        String security = ip + "<yutu_frame>" + request.getHeader("User-Agent");

        //日志实体类 并赋值
        TSysLandinglog landing = new TSysLandinglog();
        landing.setUuid(UUID.randomUUID().toString());
        landing.setLoginResult(msgPack.getStatus());
        landing.setLoginAddress(address);
        landing.setLoginAccount(userName);
        landing.setLoginDate(new Date());
        landing.setLoginIp(ip);
        landing.setLoginType("用户登陆");
        HttpSession session = request.getSession();

        //判断登录是否成功
        if (userInfo != null) {
            //session存储用户信息操作
            SessionUser sessionUser = new SessionUser();
            sessionUser.setSessionUuid(session.getId());
            sessionUser.setUuid(userInfo.getUuid());
            sessionUser.setUserAccount(userInfo.getUserAccount());
            sessionUser.setUserName(userInfo.getUserName());
            sessionUser.setUserEmail(userInfo.getUserEmail());
            sessionUser.setUserPhone(userInfo.getUserPhone());
            sessionUser.setUserLock(userInfo.getUserLock());
            sessionUser.setUserStatus(userInfo.getUserStatus());
            sessionUser.setUserSafety(security);
            //判断session 存储sesion对象
            if (session.isNew()) {
                session.setAttribute(session.getId(), sessionUser);
            }

            //记录登录信息并返回
            msgPack.setStatus(1);
            msgPack.setMsg("登录成功！");

            //记录日志
            landing.setLoginUserid(userInfo.getUuid());
            landing.setLoginSessionid(session.getId());
        } else {
            //记录登录信息并返回
            msgPack.setStatus(0);
            msgPack.setMsg("登录失败！");
        }

        //数据库存储登录日志
        int landingCount = sysLandinglogMapper.insetLoginLog(landing);
        System.out.print("=============================>登陆日志插入" + landingCount + "条-------------------------------\r\n");

        return msgPack;
    }
}
