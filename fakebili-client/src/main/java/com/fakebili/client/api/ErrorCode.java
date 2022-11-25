package com.fakebili.client.api;

/**
 * @author zzl
 * @time 2022/11/23 15:47:36
 * @description 状态码抽象方法接口
 * @version  0.1.0
 */
public interface ErrorCode {
    /**
     * Integer 获取状态信息
     *
     * @return String
     */
    String getCode();

    /**
     * String 获取信息
     *
     * @return String
     */
    String getMessage();
}
