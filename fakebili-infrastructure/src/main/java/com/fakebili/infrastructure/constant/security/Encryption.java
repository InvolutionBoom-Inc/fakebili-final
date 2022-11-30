package com.fakebili.infrastructure.constant.security;

import cn.hutool.crypto.digest.MD5;

/**
 * @author zzl
 * @date 2022/11/30 13:52:09
 * @description 加密
 */
public class Encryption {
    public static String addSalt(String password) {
        return MD5.create().digestHex(password + "114514");
    }
}
