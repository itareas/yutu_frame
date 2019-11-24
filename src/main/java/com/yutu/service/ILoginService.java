package com.yutu.service;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysLandinglog;
import com.yutu.entity.table.TSysUserinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:ILoginService
 * @Author:zhaobc
 * @Date:2019/4/16 11:55
 * @Description:登录服务接口层
 **/
public interface ILoginService {
    /**
     * @Author:zhaobc
     * @Date:2019/4/16 15:20
     * @Description:查询用户名信息
     **/
    MsgPack getLoginVerification(HttpServletRequest request, String userName, String userPwd);

}
