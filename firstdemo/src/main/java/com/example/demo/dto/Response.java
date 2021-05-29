package com.example.demo.dto;

import com.example.demo.constant.ErrorCodeEnum;
import lombok.Getter;
import org.jetbrains.annotations.Contract;

@Getter
public class Response<T> {
    /*
     * 状态码，比如1000代表响应成功
     */
    private final int code;

    /*
     * 响应信息，用来说明响应情况
     */
    private final String msg;

    /*
     * 响应的具体数据
     */
    private T data;

    public Response(T data) {
        this.code = ErrorCodeEnum.SUCCESS.getCode();
        this.msg = ErrorCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}


