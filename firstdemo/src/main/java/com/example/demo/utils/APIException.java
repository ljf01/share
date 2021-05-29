package com.example.demo.utils;

import com.example.demo.constant.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
    private final int code;
    private final String msg;

    public APIException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }
}