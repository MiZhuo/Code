package fun.mizhuo.hrserver.model;

/**
 * @author: Mizhuo
 * @time: 2020/8/19 10:29 下午
 * @description: 通用返回实体类
 */
public class ResponseVo {
    private Integer code;

    private String msg;

    private Object result;

    public static ResponseVo ok(String msg){
        return new ResponseVo(200,msg,null);
    }

    public static ResponseVo ok(String msg,Object result){
        return new ResponseVo(200,msg,result);
    }

    public static ResponseVo error(String msg){
        return new ResponseVo(500,msg,null);
    }

    public static ResponseVo error(String msg,Object result){
        return new ResponseVo(500,msg,result);
    }

    public static ResponseVo build(Integer code,String msg,Object result){
        return new ResponseVo(code,msg,result);
    }

    public static ResponseVo build(String msg,Object result){
        return build(200,msg,result);
    }

    private ResponseVo() {
    }

    private ResponseVo(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getResult() {
        return result;
    }
}
