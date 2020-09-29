package com.example.spring.web.rest.exception;

/**
 *自定义的错误描述枚举类需实现该接口
 * @author wz
 * @date 2020年8月27日
 */
public interface BaseErrorInfoInterface {

    /**
     * 获取异常结果 类型
     * @return string
     */
    String getResultType();

    /**
     *获取错误描述
     * @return string
     */
    String getResultMsg();
}
