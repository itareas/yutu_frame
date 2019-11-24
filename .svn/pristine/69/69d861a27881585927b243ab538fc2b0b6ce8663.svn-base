package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.util.AESUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AppController
 * @Author: zhaobc
 * @Date: 2019/4/23
 * @Description: 移动端服务接口  接口类型：httpClent
 **/
@Controller
@RequestMapping("/api/app")
public class AppService {
    @RequestMapping(value = "/getTest", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTest(String key, String value) {
        MsgPack msgPack = new MsgPack();
        if (key != null && value != null) {
            msgPack.setStatus(1);
            msgPack.setMsg("成功！");
        } else {
            msgPack.setStatus(0);
            msgPack.setMsg("key或者value为null");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("OurFavorite", "Hello World");
        map.put(key, value);
        msgPack.setData(map);
        //创建加密泛型类
        AESUtils<MsgPack> aes =new AESUtils<MsgPack>();
        String aesMsgPack = aes.encrypt(msgPack);
        //MsgPack decryptMsgPack = AESUtil.decrypt(aesMsgPack);
        //System.out.print("=========>" + decryptMsgPack + "--------------");
        return aesMsgPack;
    }
}
