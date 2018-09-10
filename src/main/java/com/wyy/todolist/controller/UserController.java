package com.wyy.todolist.controller;

import com.wyy.todolist.common.constant.SessionConstant;
import com.wyy.todolist.domain.enums.LoginStatus;
import com.wyy.todolist.domain.result.CommonResult;
import com.wyy.todolist.model.User;
import com.wyy.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user, HttpServletResponse response) {
        CommonResult loginResult = userService.validateUser(user);
        //登陆成功
        if (loginResult.getResultCode() != LoginStatus.SUCCESS.getCode()) {
            return  loginResult;
        }
        Cookie cookie = new Cookie(SessionConstant.USER_KEY, user.getId().toString());
        cookie.setPath("/");
        response.addCookie(cookie);
        getSession().setAttribute(SessionConstant.USER_KEY, loginResult.getData());
        return loginResult;

    }

}
