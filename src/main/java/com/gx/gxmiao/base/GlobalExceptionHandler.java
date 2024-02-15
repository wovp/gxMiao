package com.gx.gxmiao.base;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.util.SaResult;
import com.gx.gxmiao.common.ResponseExceptionDataEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.gx.gxmiao.base
 * Description:
 * Author: gx
 * Creat: 2024/2/15 15:31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常拦截
    @ExceptionHandler({NotLoginException.class})
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(ResponseExceptionDataEnum.NOT_LOGIN.getMessage());
    }
}

