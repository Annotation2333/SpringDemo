package com.example.spring.web.rest.result;

import com.alibaba.fastjson.JSONObject;
import com.example.spring.web.rest.exception.BaseErrorInfoInterface;
import com.example.spring.web.rest.exception.ExceptionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 借鉴师傅 请求对象结果 统一封装
 * @date 2020-09-28
 * @author zml
 */
@ApiModel("HTTP统一返回对象")
public class ResultBody {

    /**
     * 响应结果类型
     * 有3种结果值： success, exception, error
     */
    @ApiModelProperty(value="success, exception, error")
    private String resultType;

    /**
     * 响应消息
     * exception异常 抛出国际化的key 需要让前端做国际化。
     * error 异常直接抛出异常内容
     */
    @ApiModelProperty(value="响应消息： exception异常 抛出国际化的key 需要让前端做国际化 error：异常直接抛出异常内容")
    private String resultMsg;

    /**
     * 响应结果  数据对象
     */
    @ApiModelProperty(value="响应结果  数据对象")
    private Object resultData;

    private ResultBody(){

    }

    private ResultBody(Object resultData) {
        this.resultData = resultData;
    }

    public ResultBody(BaseErrorInfoInterface errorInfo) {
        this.resultType = errorInfo.getResultType();
        this.resultMsg = errorInfo.getResultMsg();
    }

    /**
     * 成功 返回操作结果 无数据对象
     * @return 结果对象
     */
    public static ResultBody success() {
        return success(null);
    }


    /**
     * 成功 包含数据对象
     * @param data 数据对象
     * @return 结果对象
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody(data);
        rb.setResultType(ExceptionEnum.SUCCESS.getResultType());
        rb.setResultMsg(ExceptionEnum.SUCCESS.getResultMsg());
        rb.setResultData(data);
        return rb;
    }

    /**
     * 错误结果构造
     * @param errorInfo 错误信息
     * @return 错误对象
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setResultType(errorInfo.getResultType());
        rb.setResultMsg(errorInfo.getResultMsg());
        rb.setResultData(null);
        return rb;
    }

    /**
     * 异常结果构造
     * @param exception 异常对象
     * @param exceptionMsg 异常信息
     * @return 错误对象
     */
    public static ResultBody exception(BaseErrorInfoInterface exception, String exceptionMsg) {
        ResultBody rb = new ResultBody();
        rb.setResultType(exception.getResultType());
        rb.setResultMsg(exceptionMsg);
        rb.setResultData(null);
        return rb;
    }


    /**
     * 错误结果构造
     * @param code 错误码
     * @param message 错误消息
     * @return 错误对象
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setResultType(code);
        rb.setResultMsg(message);
        rb.setResultData(null);
        return rb;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
