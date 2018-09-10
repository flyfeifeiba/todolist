package com.wyy.todolist.service.Impl;

import com.wyy.todolist.domain.enums.LoginStatus;
import com.wyy.todolist.domain.result.CommonResult;
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
    public CommonResult validateUser(User user) {
        CommonResult result = CommonResult.CreateDefaultResult();
        if (user == null) {
            result.setResultCode(LoginStatus.USER_NULL.getCode());
            result.setResultMsg(LoginStatus.USER_NULL.getMsg());
            return result;
        }
        if (user.getUsername() == null) {
            result.setResultCode(LoginStatus.USERNAME_NULL.getCode());
            result.setResultMsg(LoginStatus.USERNAME_NULL.getMsg());
            return result;
        }
        if (user.getPassword() == null) {
            result.setResultCode(LoginStatus.PASSWORD_NULL.getCode());
            result.setResultMsg(LoginStatus.PASSWORD_NULL.getMsg());
            return result;
        }
        User loginUser = userMapper.selectByUsername(user.getUsername());
        if (loginUser == null) {
            result.setResultCode(LoginStatus.USERNAME_ERROR.getCode());
            result.setResultMsg(LoginStatus.USERNAME_ERROR.getMsg());
            return result;
        }
        if (user.getPassword() != loginUser.getPassword()) {
            result.setResultCode(LoginStatus.PASSWORD_ERROR.getCode());
            result.setResultMsg(LoginStatus.PASSWORD_ERROR.getMsg());
            return result;
        }

        result.setResultCode(LoginStatus.SUCCESS.getCode());
        result.setResultMsg(LoginStatus.SUCCESS.getMsg());
        result.setData(loginUser);
        return  result;

    }

    @Override
    public User getUserById(Long id) {
        if (id == null) {
            return null;
        }
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }


    @Override
    public List<User> getAllUser() {
        return null;
    }


}
