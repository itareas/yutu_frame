package com.yutu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName: CodecUtil
 * @Author: zhaobc
 * @Date: 2019/6/20 17:25
 * @Description: 编码解吗工具类
 **/
public class CodecUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtils.class);

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 17:26
     * @Description: URL编码
     **/
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure", e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return target;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 17:26
     * @Description: URL解吗
     **/
    public static String dencodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure", e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return target;
    }
}
