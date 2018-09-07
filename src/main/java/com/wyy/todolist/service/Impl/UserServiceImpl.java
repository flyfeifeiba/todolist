package com.wyy.todolist.service.Impl;

import com.wyy.todolist.mapper.BaseDao;
import com.wyy.todolist.mapper.UserMapper;
import com.wyy.todolist.model.User;
import com.wyy.todolist.service.UserService;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Boolean validateUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        if (id == null) {
            return null;
        }
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }


}
