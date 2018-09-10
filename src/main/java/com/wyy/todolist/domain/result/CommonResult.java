package com.wyy.todolist.domain.result;

public class CommonResult extends Result{
    private Object data;

    public CommonResult(Integer resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    public CommonResult(Integer resultCode, String resultMsg, Object data) {
        super(resultCode, resultMsg);
        this.data = data;
    }

    public static CommonResult CreateDefaultResult(){
        CommonResult commonResult = new CommonResult(0, "");
        commonResult.setData(new Object());
        return commonResult;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
