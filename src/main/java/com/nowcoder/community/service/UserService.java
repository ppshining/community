package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hpr
 * @version 1.0.0
 * @date 2022-03-10 11:43
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }


}
