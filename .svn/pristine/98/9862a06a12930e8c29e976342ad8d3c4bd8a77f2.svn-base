package com.yutu.exception;

import com.yutu.entity.MsgPack;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: GlobalExceptionHandler
 * @Author: zhaobc
 * @Date: 2019/4/22 15:22
 * @Description:全局异常处理: 使用 @RestControllerAdvice + @ExceptionHandler 注解方式实现全
 * * 局异常处理
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    /**
     * @Author: zhaobc
     * @Date: 2019/4/22 15:36
     * @Description: 处理所有不可知的异常
     **/
    @ExceptionHandler({Exception.class})    //申明捕获那个异常类
    public Object globalExceptionHandler(Exception e, HttpServletRequest request) {
        //记录错误日志
        this.logger.error(e.getMessage(),e);
        //业务处理
        MsgPack msgPack = new MsgPack();
        msgPack.setStatus(500);
        msgPack.setMsg("未知异常，请联系管理员");

        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = request.getHeader("Content-Type");
        String acceptHeader = request.getHeader("Accept");
        String xRequestedWith = request.getHeader("X-Requested-With");
        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return msgPack;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace());
            modelAndView.setViewName("error");
            return modelAndView;
        }

    }


    /**
     * @Author: zhaobc
     * @Date: 2019/4/22 15:37
     * @Description: 处理所有业务异常
     **/
    @ExceptionHandler({BaseBusinessException.class})
    public Object BusinessExceptionHandler(BaseBusinessException e, HttpServletRequest request) {
        //记录错误日志
        this.logger.error(e.getMessage(),e);
        //业务处理
        MsgPack msgPack = new MsgPack();
        msgPack.setStatus(((BaseBusinessException)e).getCode());
        msgPack.setMsg(((BaseBusinessException) e).getMsg());

        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = request.getHeader("Content-Type");
        String acceptHeader = request.getHeader("Accept");
        String xRequestedWith = request.getHeader("X-Requested-With");
        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return msgPack;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/4/23 14:41
     * @Description: 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     **/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("请求有参数才进来");
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/4/23 14:42
     * @Description: 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     **/
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "zhaobc");
    }
}