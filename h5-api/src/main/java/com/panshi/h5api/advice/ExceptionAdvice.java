package com.panshi.h5api.advice;


import com.panshi.domail.ResultVO;
import com.panshi.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultVO businessExceotion(BusinessException e){
        //当捕获到此异常时,返回Message对象到前台-------所以加上@ResponseBody注解
        return new ResultVO(e.getCode(), e.getMessage());
    }
}