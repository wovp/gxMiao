package com.gx.gxmiao.common;

/**
 * ClassName: ResponseExceptionDataEnum
 * Package: com.gx.gxmiao.common
 * Description:
 * Author: gx
 * Creat: 2024/2/15 15:38
 */
/**
 * 枚举类，定义了响应异常的消息
 */
public enum ResponseExceptionDataEnum {
    /**
     * 未登录异常消息
     */
    NOT_LOGIN("请登录"),

    /**
     * 凭证失效异常消息
     */
    TOKEN_EXPIRED("凭证失效"),

    /**
     * 未提供凭证异常消息
     */
    TOKEN_NULL("请登录"),

    /**
     * 访问被拒绝异常消息
     */
    ACCESS_DENIED("访问被拒绝");

    private final String message;

    /**
     * 构造函数
     *
     * @param message 异常消息
     */
    ResponseExceptionDataEnum(final String message) {
        this.message = message;
    }

    /**
     * 获取异常消息
     *
     * @return 异常消息
     */
    public String getMessage() {
        return message;
    }
}
