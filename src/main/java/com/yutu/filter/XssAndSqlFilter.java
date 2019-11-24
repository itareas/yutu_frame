package com.yutu.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.ConfigConstants;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: XssAndSqlFilter
 * @Author: zhaobc
 * @Date: 2019/6/15 20:01
 * @Description:Xss和Sql注入漏洞攻击防御
 **/
public class XssAndSqlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //首先判断是否启动此机制
        if(!SystemPropertiesConfig.System_XssAndSql_StartUp.equals("true")){
            chain.doFilter(servletRequest,servletResponse);
            return;
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String method = "GET";
        String param = "";
        XssAndSqlHttpServletRequestWrapper xssRequest = null;
        if (request instanceof HttpServletRequest) {
            method = ((HttpServletRequest) request).getMethod();
            xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);
        }
        if ("POST".equalsIgnoreCase(method)) {
            param = this.getBodyString(xssRequest.getReader());
            if(StringUtils.isNotBlank(param)){
                if(xssRequest.checkXSSAndSql(param)){
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    //重定向到登录页  并给予错误提示
                    response.sendRedirect(SystemPropertiesConfig.System_Login_Page);
                    //out.write(JSONResponseUtil.getWrappedERRString("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!"));
                    return;
                }
            }
        }
        if (xssRequest.checkParameter()) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //重定向到登录页 并给予错误提示
            response.sendRedirect(SystemPropertiesConfig.System_Login_Page);
            //out.write(JSONResponseUtil.getWrappedERRString("您所访问的页面请求中有违反安全规则元素存在，拒绝访问!"));
            return;
        }
        chain.doFilter(xssRequest, response);
    }

    @Override
    public void destroy() {

    }


    // 获取request请求body中参数
    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;

    }
}
