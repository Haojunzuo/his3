package com.neusoft.mapper;

import com.neusoft.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface UserMapper {
    public List<String> selectRoles();
    public List<User> selectUser(User u);//尽量返回list，然後在service层进行判断
}