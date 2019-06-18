package com.wyy.todolist.service.Impl;

import com.wyy.todolist.dao.UserDao;
import com.wyy.todolist.domain.enums.LoginStatus;
import com.wyy.todolist.domain.enums.RegisterStatus;
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

    @Autowired
    private UserDao userDao;

    @Override
    public CommonResult validateUser(User user) {
        CommonResult result = null;
        if (user == null) {
            result = new CommonResult(LoginStatus.USER_NULL.getCode(), LoginStatus.USER_NULL.getMsg());
            return result;
        }
        if (user.getUsername() == null) {
            result = new CommonResult(LoginStatus.USERNAME_NULL.getCode(), LoginStatus.USERNAME_NULL.getMsg());
            return result;
        }
        if (user.getPassword() == null) {
            result = new CommonResult(LoginStatus.PASSWORD_NULL.getCode(), LoginStatus.PASSWORD_NULL.getMsg());
            return result;
        }
        User loginUser = userMapper.selectByUsername(user.getUsername());
        if (loginUser == null) {
            result = new CommonResult(LoginStatus.USERNAME_ERROR.getCode(), LoginStatus.USERNAME_ERROR.getMsg());
            return result;
        }
        if (!user.getPassword().equals(loginUser.getPassword())) {
            result = new CommonResult(LoginStatus.PASSWORD_ERROR.getCode(), LoginStatus.PASSWORD_ERROR.getMsg());
            return result;
        }

        result = new CommonResult(LoginStatus.SUCCESS.getCode(), LoginStatus.SUCCESS.getMsg());
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

    @Override
    public CommonResult register(User user) {
        CommonResult result = null;
        //判断用户是否已经存在
        if(userDao.judgeUserExist(user.getUsername())) {
            result = new CommonResult(RegisterStatus.USERNAME_EXIST.getCode(),
                    RegisterStatus.USERNAME_EXIST.getMsg());
            return result;
        }

        return result;
    }


}
