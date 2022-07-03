package fun.mizhuo.seckill.controller;

import fun.mizhuo.seckill.entity.User;
import fun.mizhuo.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: GoodsController
 * @Author: MiZhuo
 * @Date: 2022/6/4 22:33
 * @Description: 商品controller
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    IUserService userService;

    @RequestMapping("/toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket){
        if(!StringUtils.hasText(ticket)){
            return "login";
        }
        User user = userService.getUserByCookie(ticket,request,response);
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        return "goodsList";
    }
}
