package com.wyy.todolist.domain.result;

public class CommonResult extends Result{
    private Object data;

    public CommonResult(Integer resultCode, String resultMsg, Object data) {
        super(resultCode, resultMsg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
