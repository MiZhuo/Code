package fun.mizhuo.hrserver.controller.system.basic;

import fun.mizhuo.hrserver.model.Menu;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.model.Role;
import fun.mizhuo.hrserver.service.common.MenuRoleService;
import fun.mizhuo.hrserver.service.common.MenuService;
import fun.mizhuo.hrserver.service.system.basic.RoleTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/11 7:04 下午
 * @description: 权限组Controller
 */
@Api(value = "权限组Controller",tags = {"权限组管理接口"})
@RestController
@RequestMapping("system/basic/roleTeam")
public class RoleTeamController {

    @Autowired
    RoleTeamService roleTeamService;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色信息")
    @GetMapping("/")
    public ResponseVo getAllRoles(){
        List<Role> roles = roleTeamService.getAllRoles();
        return ResponseVo.ok("",roles);
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public ResponseVo addRole(@RequestBody Role role){
        if(roleTeamService.addRole(role) == 1){
            return ResponseVo.ok("添加角色成功!");
        }
        return ResponseVo.error("添加角色失败!");
    }

    @ApiOperation(value = "删除角色信息")
    @DeleteMapping("/{roleId}")
    public ResponseVo deleteRoleByRoleId(@PathVariable Integer roleId){
        if(roleTeamService.deleteRoleByRoleId(roleId) == 1){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "获取菜单树")
    @GetMapping("/menuTree")
    public ResponseVo getMenuTree(){
        List<Menu> menus = menuService.getMenuTree();
        return ResponseVo.ok("",menus);
    }

    @ApiOperation(value = "获取权限菜单信息")
    @GetMapping("/menuTree/checked/{id}")
    public ResponseVo getMenuTreeCheckedByRoleId(@PathVariable Integer id){
        Integer[] menuRoles = menuRoleService.getMenuIdsByRoleId(id);
        return ResponseVo.ok("",menuRoles);
    }

    @ApiOperation(value = "更新权限菜单信息")
    @PutMapping("/modify/menu/{roleId}")
    public ResponseVo modifyMenuByRoleId(@PathVariable int roleId, @RequestBody Integer[] menuIds){
        if(menuRoleService.modifyMenuByRoleId(roleId,menuIds) >= 0){
            return ResponseVo.ok("更新成功!");
        }
        return ResponseVo.error("更新失败!");
    }
}
