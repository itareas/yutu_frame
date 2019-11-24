package com.yutu.controller;

import com.yutu.entity.MsgPack;
import com.yutu.service.IHomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: HomeController
 * @Author: zhaobc
 * @Date: 2019/6/26 17:34
 * @Description:框架主页数据测试
 **/
@RestController
@RequestMapping(value = "home")
public class HomeController {
    @Resource
    private IHomeService homeService;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/26 17:37
     * @Description: 获得所有数据源数据
     **/
    @RequestMapping(value = "getDataSource")
    public MsgPack getDataSource() {
        MsgPack msgPask = new MsgPack();
        msgPask = homeService.getDataSource();
        return msgPask;
    }
}
