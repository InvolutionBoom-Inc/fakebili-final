package com.fakebili.domain.role;

/**
 * @author lgz
 * @version 0.1.0 2022/11/28 10:11:32
 * @since 0.1.0
 */
public interface RoleGateway {

    /**
     * 判断id是否存在
     * @param id id
     * @return 是否
     */
    Boolean checkById(Integer id);
}
