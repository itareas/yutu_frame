package com.yutu.service.impl;

import com.yutu.entity.table.TSysLandinglog;
import com.yutu.mapper.mysql.TSysLandinglogMapper;
import com.yutu.service.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: LogServiceImpl
 * @Author: zhaobc
 * @Date: 2019/4/21 17:30
 * @Description: 日志操作类
 **/
@Service
public class LogServiceImpl implements ILogService {
    @Resource
    private TSysLandinglogMapper sysLandinglogMapper;

    /**
     * @Author: zhaobc
     * @Date: 2019/5/20 11:20
     * @Description: 插入登陆日志功能   @Transactional 事务启动注解
     **/
    @Override
    @Transactional(transactionManager = "mySqlTransactionManager")
    public int insetLoginLog(TSysLandinglog landing) {
        return 0;
    }
}
