package com.fakebili.client.user.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.fakebili.client.user.dto.command.UserInfoUpdateCmd;
import com.fakebili.client.user.dto.command.UserStatisticSaveCmd;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:29
 * @since 0.1.0
 */
public interface IUserStatisticService {

    /**
     * 保存用户统计信息
     * @param cmd cmd
     * @return response
     */
    Response save(UserStatisticSaveCmd cmd);

    /**
     * 获取用户个人信息
     *
     * @return response
     */
    SingleResponse<Map<String, Object>> getUserInfo(Integer id);

    /**
     * 修改用户资料
     * @return
     */
    Response update(UserInfoUpdateCmd cmd);
}
