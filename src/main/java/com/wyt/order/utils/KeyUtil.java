package com.wyt.order.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一主键
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
