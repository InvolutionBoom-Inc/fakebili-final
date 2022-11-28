package com.fakebili.infrastructure.user.gateway.impl.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fakebili.infrastructure.user.gateway.impl.database.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lgz
 * @version 0.1.0 2022/11/24 18:11:53
 * @since 0.1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据用户ID查询该权限
     * @param userId 用户ID
     * @return 权限
     */
    List<String> selectPermsByUserId(Integer userId);

    /**
     * 根据用户ID查询该角色
     * @param userId 用户ID
     * @return 角色
     */
    List<String> selectRolesByUserId(Integer userId);

}
