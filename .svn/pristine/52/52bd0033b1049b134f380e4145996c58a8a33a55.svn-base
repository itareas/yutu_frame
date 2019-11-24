package com.yutu.util;

import java.lang.reflect.ParameterizedType;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yutu.entity.MsgPack;
import org.apache.commons.codec.binary.Base64;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtils<T> {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
    private static final String AES_KEY = "#ZBC&zjx@20170403_.Love_V1.0!";

    /**
     * @Author: zhaobc
     * @Date: 2019/5/29 11:07
     * @Description: AES加密
     **/
    public static String encryptOne(MsgPack msgPack) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 把对象转成json
            byte[] byteContent = JSON.toJSONString(msgPack).getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(AES_KEY));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/5/29 11:08
     * @Description: AES解密
     **/
    public static MsgPack decryptOne(String content) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(AES_KEY));
            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            //先把字节流转成字符串
            String strPack= new String(result, "utf-8");
            //字节流转对象
            MsgPack msgPack = JSON.parseObject(strPack,MsgPack.class);
            //返回相关对象
            return msgPack;
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/5/29 11:07
     * @Description: AES加密实体类  msgPack 传递的中间类
     **/
    public  String encrypt(T msgPack) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 把对象转成json
            byte[] byteContent = JSON.toJSONString(msgPack).getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(AES_KEY));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    /**
     *@Author: zhaobc
     *@Date: 2019/6/22 18:03
     *@Description: AES加密字符串
     **/
    public  String encrypt(String content) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            // 把对象转成json
            byte[] byteContent = content.getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(AES_KEY));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/5/29 11:08
     * @Description: AES解密  clazz 为MsgPack消息包中data的类型
     **/
    public <T> MsgPack<T> decrypt(String content,Class<T> clazz) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(AES_KEY));
            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            //先把字节流转成字符串
            String strPack= new String(result, "utf-8");
            //字节流转对象
            return JSONObject.parseObject(strPack, new TypeReference<MsgPack<T>>(clazz) {});
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/5/29 11:08
     * @Description: AES解密  clazz 为MsgPack消息包中data的类型
     **/
    public String decrypt(String content) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(AES_KEY));
            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            //先把字节流转成字符串
            String strPack= new String(result, "utf-8");
            //返回字符串信息
            return strPack;
        } catch (Exception ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/5/29 11:08
     * @Description: 生成密匙  兼容linux
     **/
    private static SecretKeySpec getSecretKey(final String password) throws NoSuchAlgorithmException {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //AES 要求密钥长度为 128
            kg.init(128, random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}