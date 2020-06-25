package com.neusoft.service;

import com.neusoft.entity.User;
import com.neusoft.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public List<String> selectRoles(){
        return userMapper.selectRoles();
    }
    public User selectUser(User u){
        List<User> list = userMapper.selectUser(u);
        if (list != null && list.size()==1) {
            return list.get(0);
        }else{
            return null;
        }
    }
}