package com.ssm.bean;

/**
 * @author ZhangRunKai
 * @date 2020/7/5 15:43
 */
public class Result {

    private Integer code;

    private String message;

    private Object data;

    //请求成功
    private final static Integer SUCCESSCODE = 200;
    //缺少必要参数，请求失败
    private final static Integer VALIDATCODE = 400;
    //需要求身份验证
    private final static Integer AUTHCODE = 401;
    //服务器发生错误
    private final static Integer FAILCODE = 500;
    //服务器繁忙
    private final static Integer ERRORCODE = 510;


    private final static String SUCCESSMESSAGE = "请求成功！";
    private final static String FAILMESSAGE = "服务器发生错误！";
    private final static String VALIDATMESSAGE = "表单验证失败！";
    private final static String AUTHMESSAGE = "身份认证失败！";
    private final static String ERRORMESSAGE = "服务器繁忙！";

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        return new Result(SUCCESSCODE,SUCCESSMESSAGE,null);
    }
    public static Result success(Object data){
        return new Result(SUCCESSCODE,SUCCESSMESSAGE,data);
    }

    public static Result fail(){
        return new Result(FAILCODE,FAILMESSAGE,null);
    }

    public static Result authFail(){
        return new Result(AUTHCODE,AUTHMESSAGE,null);
    }

    public static Result validatFail(){
        return new Result(VALIDATCODE,VALIDATMESSAGE,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
