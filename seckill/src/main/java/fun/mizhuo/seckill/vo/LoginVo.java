package fun.mizhuo.seckill.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassName: LoginVo
 * @Author: MiZhuo
 * @Date: 2022/5/29 21:31
 * @Description: 登录参数
 */
@Data
public class LoginVo {
    @NotNull
    @Pattern(regexp = "[1]([3-9])[0-9]{9}$",message = "手机号格式错误!")
    private String mobile;
    @NotNull
    private String password;
}
