package fun.mizhuo.seckill.controller;

import fun.mizhuo.seckill.service.IUserService;
import fun.mizhuo.seckill.vo.LoginVo;
import fun.mizhuo.seckill.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @ClassName: LoginController
 * @Author: MiZhuo
 * @Date: 2022/5/29 16:26
 * @Description: 登录Controller
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    IUserService userService;

    /**
     * @Author MiZhuo
     * @Description 跳转登录页面
     * @Date 20:44 2022/5/29
     * @return java.lang.String
    **/
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * @Author MiZhuo
     * @Description 登录功能
     * @Date 21:37 2022/5/29
     * @param loginVo
     * @return fun.mizhuo.seckill.vo.ResponseVo
    **/
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResponseVo<Object> doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        log.info("{}",loginVo);
        return userService.doLogin(loginVo,request,response);
    }
}
