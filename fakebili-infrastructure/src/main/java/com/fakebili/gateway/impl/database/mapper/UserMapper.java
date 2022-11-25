package com.fakebili.gateway.impl.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fakebili.gateway.impl.database.dataobject.UserDO;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 18:11:53
 * @since 0.1.0
 */
public interface UserMapper extends BaseMapper<UserDO> {

    String selectPassword(String username);

}
