package com.nan.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {

    private int code;   // 编码 200 , 400
    private String msg; // 成功 or 失败
    private Long total; // 总记录数
    private Object data; //数据


    public static Result fail() {
        return result(400, "失败", 0L, null);
    }

    public static Result success() {
        return result(200, "成功", 0L, null);
    }


    public static Result success(Object data) {
        return result(200, "成功", 0L, data);
    }

    public static Result success(Object data, Long total) {
        return result(200, "成功", total, data);
    }

    private static Result result(int code, String msg, Long total, Object data) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }
}
