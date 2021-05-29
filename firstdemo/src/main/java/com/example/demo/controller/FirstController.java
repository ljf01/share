package com.example.demo.controller;

import com.example.demo.dto.Response;
import com.example.demo.dto.UserInfoIDto;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.*;

import javax.validation.Valid;

import com.example.demo.constant.*;

@RestController
public class FirstController {

    @PostMapping("/welcome")
    public String Welcome(@Valid @RequestBody UserInfoIDto userInfoIDto, BindingResult result) {
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            if (fieldError == null) throw new AssertionError();
            String field = fieldError.getField();
            String msg = fieldError.getDefaultMessage();
            return field + ":" + msg;
        }
        System.out.println("开始注册用户...");
        return "success";

    }

    @GetMapping("/users")
    public Response<UserInfoIDto> Test() {
        UserInfoIDto userInfoIDto = new UserInfoIDto();
        userInfoIDto.setUsername("monday");
        userInfoIDto.setAge(30);
        userInfoIDto.setPhone("123456789");
        throw new APIException(ErrorCodeEnum.ERROR);
    }
}