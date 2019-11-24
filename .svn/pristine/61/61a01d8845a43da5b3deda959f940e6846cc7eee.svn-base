package com.yutu.interceptor;


import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.SessionUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName: MyInterceptor
 * @Author: zhaobc
 * @Date: 2019/4/19
 * @Description:
 **/
public class MyInterceptor implements HandlerInterceptor {


    static Logger logger = Logger.getLogger(MyInterceptor.class);

    public MyInterceptor() {
        super();
    }
    private long overtime;

    /**
     *@Author: zhaobc
     *@Date: 2019/4/19
     *@Description: 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     * 该方法验证token是否过期，如果token过期，立即退出到登录页
     **/
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object arg2) throws Exception {
        //获取访问过来的Sessid
        String sessionId = request.getSession().getId(); // token
        boolean returnBool=false;
        // 是否启动拦截器
        String startUpInterceptor = SystemPropertiesConfig.System_Interceptor_StartUp;
        // 超时时间
        int interceptorOverTime = Integer.parseInt(SystemPropertiesConfig.System_Interceptor_OverTime);
        if (StringUtils.isNotBlank(StringUtils.trimToNull(sessionId))) {
            HttpSession session = request.getSession(false);
            SessionUser user = session.getAttribute(session.getId())==null?null:(SessionUser)session.getAttribute(session.getId());
            if (user != null) {
                if (startUpInterceptor.equals("true")) { // 判断是否启动
                    if (new Date().getTime() - overtime > interceptorOverTime) { // 1s钟最多调用一次
                        if (remoteVerify(sessionId)) {
                            overtime = new Date().getTime();
                            returnBool= true; // 验证有效
                        } else {
                            //单独返回  不能用response.sendredirect  iframe里面刷新  后面不会
                            response.setContentType("text/html;charset=UTF-8");
                            PrintWriter out = response.getWriter();
                            out.write("<html>");
                            out.write("<body>");
                            out.write("<script type=\"text/javascript\">");
                            out.println("window.open ('"+request.getContextPath()+"/login/logout.do','_top')");
                            out.write("</script>");
                            out.write("</body>");
                            out.write("</html>");
                            return false; // 验证无效
                        }
                    } else {
                        returnBool= true;
                    }
                } else {
                    returnBool= true;
                }
            }
        }
        //判断 false 跳转首页
        if(!returnBool){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("<html>");
            out.write("<body>");
            out.write("<script type=\"text/javascript\">");
            out.println("window.open ('"+request.getContextPath()+"/','_top')");
            out.write("</script>");
            out.write("</body>");
            out.write("</html>");
        }
        return returnBool;
    }

    //核心方法，通过接口验证token是否过期
    private  boolean remoteVerify(String token) throws Exception {
        if(StringUtils.isNotBlank(StringUtils.trimToNull(token))) {
            //访问token接口
            int overTime = 0;//serviceFactory.getLoginService().overTime(token);
            if (overTime == 0) {
                return true;
            }
        }
        return false;
    }

    //在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("==============================>postHandle被调用------------------------------");
    }

    //在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("=============================afterCompletion被调用---------------------------");
    }

}
