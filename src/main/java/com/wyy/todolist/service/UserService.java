package com.wyy.todolist.service;

import com.wyy.todolist.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 校验用户
     * @param user
     * @return
     */
    public Boolean validateUser(User user);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id);


    public List<User> getAllUser();

}
