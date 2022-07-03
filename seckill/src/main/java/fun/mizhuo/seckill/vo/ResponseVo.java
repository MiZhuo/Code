package fun.mizhuo.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: RespVO
 * @Author: MiZhuo
 * @Date: 2022/5/29 21:05
 * @Description: 公共返回实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo<T> implements Serializable{

    private static final long serialVersionUID = -4184671066722865531L;

    private T data;

    private Integer code;

    private String msg;

    public static <T> ResponseVo<T> success(){
        return new ResponseVo<T>(null,ResponseVoEnum.SUCCESS.getCode(),ResponseVoEnum.SUCCESS.getMsg());
    }

    public static <T> ResponseVo<T> success(T data){
        return new ResponseVo<T>(data,ResponseVoEnum.SUCCESS.getCode(),ResponseVoEnum.SUCCESS.getMsg());
    }

    public static <T> ResponseVo<T> error(ResponseVoEnum responseVoEnum){
        return new ResponseVo<T>(null,responseVoEnum.getCode(),responseVoEnum.getMsg());
    }

    public static <T> ResponseVo<T> error(ResponseVoEnum responseVoEnum,T data){
        return new ResponseVo<T>(data,responseVoEnum.getCode(),responseVoEnum.getMsg());
    }

    public static <T> ResponseVo<T> error(String msg){
        return new ResponseVo<T>(null,null,msg);
    }
}
