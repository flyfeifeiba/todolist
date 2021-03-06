package com.wyy.todolist.domain.enums;

public enum RegisterStatus {
    USER_NULL(0, "用户为空"),

    USERNAME_NULL(1, "用户名为空"),

    PASSWORD_NULL(2, "密码为空"),

    USERNAME_EXIST(3, "用户名已存在"),

    PASSWORD_ERROR(4, "用户名错误"),

    SUCCESS(5, "登录成功");

    private int code;
    private String msg;

    private RegisterStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
