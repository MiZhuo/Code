package fun.mizhuo.hrserver.util;

/**
 * @author: Mizhuo
 * @time: 2020/9/6 5:23 下午
 * @description:
 */
public class ErrMessage {
    /**
     * --------------------登录等错误信息-------------------------
     */
    public static final String SYSTEM_ERROR_MESSAGE1 = "用户名或密码错误!";
    public static final String SYSTEM_ERROR_MESSAGE2 = "访问失败,请联系管理员!";
    public static final String SYSTEM_ERROR_MESSAGE3 = "账户过期,请联系管理员.";
    public static final String SYSTEM_ERROR_MESSAGE4 = "账户被禁用!请联系管理员.";
    public static final String SYSTEM_ERROR_MESSAGE5 = "密码过期!请联系管理员.";
    public static final String SYSTEM_ERROR_MESSAGE6 = "账户被锁定!请联系管理员解锁.";
    public static final String SYSTEM_ERROR_MESSAGE7 = "权限不足，请联系管理员！";
    public static final String SYSTEM_ERROR_MESSAGE8 = "尚未登录,请登录！";
    public static final String SYSTEM_ERROR_MESSAGE9 = "验证码不存在！";
    public static final String SYSTEM_ERROR_MESSAGE10 = "验证码已过期！";
    public static final String SYSTEM_ERROR_MESSAGE11 = "验证码错误！";

    /**
     * --------------------系统管理(职位管理)错误信息-------------------------
     */
    public static final String POSITION_ERROR_MESSAGE1 = "存在关联数据,操作失败,请检查.";

    /**
     * --------------------数据库错误信息-------------------------
     */
    public static final String SQL_ERROR_MESSAGE1 = "数据异常,操作失败,请检查.";

}
