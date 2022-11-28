package com.fakebili.client.user.api;

import com.alibaba.cola.dto.Response;
import com.fakebili.client.user.dto.command.UserRoleSaveCmd;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 13:11:19
 * @since 0.1.0
 */
public interface IUserRoleService {

    /**
     * 保存用户角色关联信息
     * @param cmd cmd
     * @return response
     */
    Response save(UserRoleSaveCmd cmd);

}
