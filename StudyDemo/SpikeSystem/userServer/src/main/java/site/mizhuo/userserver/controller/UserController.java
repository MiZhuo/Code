package site.mizhuo.userserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.mizhuo.userserver.entity.DTO.UserDTO;
import site.mizhuo.userserver.entity.VO.ResultVO;
import site.mizhuo.userserver.entity.VO.UserVO;
import site.mizhuo.userserver.exception.SpikeException;
import site.mizhuo.userserver.service.IUserService;
import site.mizhuo.userserver.utils.BeanConvertUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 11:36
 * @Version 1.0
 **/
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody UserVO userVO, HttpServletRequest request){
        UserDTO userDTO = BeanConvertUtils.copyProperties(userVO,UserDTO.class);
        try {
            userDTO = userService.getUser(userDTO);
        } catch (SpikeException e) {
            return ResultVO.of(null,false,e.getMessage());
        }
        request.getSession().setAttribute("user",userDTO);
        return ResultVO.of(userDTO,true,"登陆成功!");
    }

    @PostMapping("/registry")
    public ResultVO registry(@RequestBody UserVO userVO){
        UserDTO userDTO = BeanConvertUtils.copyProperties(userVO,UserDTO.class);
        try {
            userService.insertUser(userDTO);
        } catch (SpikeException e) {
            return ResultVO.of(null,false,e.getMessage());
        }
        return ResultVO.of(userDTO,true,"注册成功!");
    }
}
