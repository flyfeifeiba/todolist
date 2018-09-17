package com.wyy.todolist.service;

import com.wyy.todolist.domain.result.CommonResult;
import com.wyy.todolist.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 校验用户
     * @param user
     * @return
     */
    public CommonResult validateUser(User user);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id);


    public User getUserByUsername(String username);


    public List<User> getAllUser();

    public CommonResult register(User user);



}
