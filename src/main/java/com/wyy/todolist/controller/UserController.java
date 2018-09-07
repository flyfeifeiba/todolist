package com.wyy.todolist.controller;

import com.wyy.todolist.model.User;
import com.wyy.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Long id){
        return userService.getUserById(id);
    }

    @RequestMapping("/getAllUser")
    public String getAllUser() {
        return "index";
    }

}
