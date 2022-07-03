package fun.mizhuo.seckill.service;

import fun.mizhuo.seckill.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import fun.mizhuo.seckill.vo.LoginVo;
import fun.mizhuo.seckill.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mizhuo
 * @since 2022-05-29
 */
public interface IUserService extends IService<User> {

    ResponseVo<Object>  doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);
}
