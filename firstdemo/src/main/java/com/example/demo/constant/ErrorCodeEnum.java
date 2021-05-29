package com.example.demo.constant;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    ERROR(5000, "未知错误"),
    FAILED(1001, "响应失败"),
    SUCCESS(1000, "成功"),
    VALIDATE_FAILED(1002, "参数校验失败");

    private final Integer code;
    private final String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
