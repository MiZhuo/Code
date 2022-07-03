package fun.mizhuo.seckill.service.impl;

import cn.hutool.core.lang.UUID;
import fun.mizhuo.seckill.entity.User;
import fun.mizhuo.seckill.exception.GlobalException;
import fun.mizhuo.seckill.mapper.UserMapper;
import fun.mizhuo.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.mizhuo.seckill.utils.CookieUtil;
import fun.mizhuo.seckill.utils.MD5Util;
import fun.mizhuo.seckill.vo.LoginVo;
import fun.mizhuo.seckill.vo.ResponseVo;
import fun.mizhuo.seckill.vo.ResponseVoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mizhuo
 * @since 2022-05-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public ResponseVo<Object> doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        User user = userMapper.selectById(mobile);
        if(null == user || !MD5Util.inputPassToDbPass(password,user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(ResponseVoEnum.LOGIN_ERROR);
        }
        //生成cookie
        String ticket = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("user:" + ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return ResponseVo.success();
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if(user != null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return StringUtils.hasText(userTicket) ? user: null;
    }
}
