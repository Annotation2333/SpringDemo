package com.example.spring.web.rest.exception;

/**
 * 异常枚举
 * @author  zml
 * @date  2020年9月28日
 */
public enum ExceptionEnum implements BaseErrorInfoInterface {

    /**
     * 结果处理成功
     */
    SUCCESS("success", "success"),


    /**
     * 普通异常
     * 需要在代码里捕获处理。
     */
    EXCEPTION("exception", "可捕获异常"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR("error", "服务器执行出错!"),

    /**
     *空指针错误
     */
    NULL_POINT_ERROR("error","程序发生空指针异常!"),


    /**
     * 时间日期转换异常
     */
    DATE_TRANSFORM_ERROR("error", "时间日期转换异常!"),
    ;
    /**
     * 异常类型
     */
    private String resultType;

    /**
     * 异常描述
     */
    private String resultMsg;

    ExceptionEnum(String resultType, String resultMsg){
        this.resultType = resultType;
        this.resultMsg = resultMsg;
    }


    @Override
    public String getResultType() {
        return resultType;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
