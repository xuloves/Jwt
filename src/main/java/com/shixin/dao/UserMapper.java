package com.shixin.dao;

import com.shixin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 今何许
 * @date 2020-08-14 14:03
 */
@Mapper
public interface UserMapper {
    User login(User user);
}