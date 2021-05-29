package com.example.demo.utils;

import com.example.demo.constant.ErrorCodeEnum;
import com.example.demo.dto.Response;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new Response<>(ErrorCodeEnum.VALIDATE_FAILED.getCode(), objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public Response<String> APIExceptionHandler(APIException e) {
        return new Response<>(e.getCode(), e.getMsg());
    }
}

