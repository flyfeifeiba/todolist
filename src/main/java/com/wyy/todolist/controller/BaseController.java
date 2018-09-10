package com.wyy.todolist.controller;

import com.wyy.todolist.common.constant.SessionConstant;
import com.wyy.todolist.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpSession getSession() {
        return getRequest().getSession();
    }


    protected User getUser() {
        return (User) getSession().getAttribute(SessionConstant.USER_KEY);
    }

    protected long getUserId() {
        Long id = 0l;
        User user = getUser();
        if(user != null){
            id = user.getId();
        }
        return id;
    }
}
