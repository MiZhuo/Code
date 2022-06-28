package fun.mizhuo.hrserver.controller.common;

import fun.mizhuo.hrserver.model.Menu;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.common.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/8/23 11:03 上午
 * @description:
 */
@Api(value = "系统级Controller",tags = {"系统级接口"})
@RestController
@RequestMapping("/sys/config")
public class SysConfigController {

    @Autowired
    MenuService menuService;

    @ApiOperation(value = "初始化菜单列表")
    @GetMapping("/menu")
    public ResponseVo initMenuByUserId(){
        List<Menu> menuList = menuService.initMenuByUserId();
        return ResponseVo.ok("",menuList);
    }
}
