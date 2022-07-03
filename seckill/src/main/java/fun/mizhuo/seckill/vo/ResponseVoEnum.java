package fun.mizhuo.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author MiZhuo
 * @Description //公共返回枚举类
 * @Date 21:09 2022/5/29
**/
@Getter
@ToString
@AllArgsConstructor
public enum ResponseVoEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),
    LOGIN_ERROR(500210,"用户名或密码错误!"),
    MOBILE_ERROR(500220,"手机号格式错误!"),
    BIND_ERROR(500230,"参数格式异常" );

    private final Integer code;
    private final String msg;
}
