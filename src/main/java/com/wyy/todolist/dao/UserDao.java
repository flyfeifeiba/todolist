package com.wyy.todolist.dao;

import com.wyy.todolist.mapper.UserMapper;
import com.wyy.todolist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public Boolean judgeUserExist(String username) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return false;
        }
        return true;
    }

    public Boolean insertUser(User user) {
        //默认用户名密码不为空
        if (userMapper.insert(user) > 0) {
            return true;
        }
        return false;

    }
}
