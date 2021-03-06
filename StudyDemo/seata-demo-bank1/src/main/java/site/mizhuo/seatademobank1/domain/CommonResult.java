package site.mizhuo.seatademobank1.domain;

/**
 * @author: Mizhuo
 * @time: 2021/3/28 4:10 下午
 * @description: 公共返回实体类
 */
public class CommonResult<T>{
    private T data;
    private Integer code;
    private String message;

    public CommonResult() {
    }

    public CommonResult(T data) {
        this(data,200,"操作成功");
    }

    public CommonResult(Integer code, String message) {
        this(null,code,message);
    }

    public CommonResult(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
}
