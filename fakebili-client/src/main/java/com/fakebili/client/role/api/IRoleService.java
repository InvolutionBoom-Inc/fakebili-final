package com.fakebili.client.role.api;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:21
 * @since 0.1.0
 */
public interface IRoleService {

    /**
     * 校验id真实性
     * @param id cmd
     * @return 是否
     */
    Boolean checkId(Integer id);
}
