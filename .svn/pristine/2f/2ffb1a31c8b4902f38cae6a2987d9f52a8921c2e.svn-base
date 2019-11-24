package com.yutu.exception;


/**
 * @ClassName: BaseBusinessException
 * @Author: zhaobc
 * @Date: 2019/4/22 15:44
 * @Description: 分析系统所有的 业务异常父类
 **/
public class BaseBusinessException extends RuntimeException  {
    private String msg;
    private int code = 500;

    public BaseBusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseBusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseBusinessException(int code,String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseBusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
