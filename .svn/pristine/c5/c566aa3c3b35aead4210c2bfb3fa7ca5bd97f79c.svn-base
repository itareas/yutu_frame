package com.yutu.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StreamUtils
 * @Author: zhaobc
 * @Date: 2019/6/1 16:24
 * @Description:list集合序列化和反序列化操作
 **/
public class StreamUtils {

    /**
     *@Author: zhaobc
     *@Date: 2019/6/1 16:26
     *@Description: 序列化
     **/
    public static <T> boolean writeObject(List<T> list, File file) {
        T[] array = (T[]) list.toArray();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(array);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *@Author: zhaobc
     *@Date: 2019/6/1 16:26
     *@Description: 反序列化
     **/
    public static <E> List<E> readObjectForList(File file) {
        E[] object;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            object = (E[]) input.readObject();
            input.close();
            return Arrays.asList(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
