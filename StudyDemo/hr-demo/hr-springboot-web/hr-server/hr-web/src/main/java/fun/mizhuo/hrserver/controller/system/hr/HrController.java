package fun.mizhuo.hrserver.controller.system.hr;

import fun.mizhuo.hrserver.model.*;
import fun.mizhuo.hrserver.model.Role;
import fun.mizhuo.hrserver.service.system.basic.RoleTeamService;
import fun.mizhuo.hrserver.service.system.hr.HrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/13 11:04 上午
 * @description: HR-Controller
 */
@Api(value = "HrController",tags = {"HR管理接口"})
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @Autowired
    RoleTeamService roleTeamService;

    @ApiOperation(value = "获取所有HR信息")
    @GetMapping("/")
    public ResponseVo getAllHrs(){
        List<Hr> hrs = hrService.getAllHrs();
        return ResponseVo.ok("",hrs);
    }

    @ApiOperation(value = "启用/禁用HR")
    @PutMapping("/{id}/{enabled}")
    public ResponseVo enabledHrById(@PathVariable Integer id,@PathVariable Boolean enabled){
        Hr hr = new Hr();
        hr.setId(id);
        hr.setEnabled(enabled);
        if(hrService.enabledHrById(hr) == 1){
            if(enabled){
                return ResponseVo.ok("启用成功!");
            }else{
                return ResponseVo.ok("禁用成功!");
            }
        }
        return ResponseVo.error("操作失败!");
    }

    @ApiOperation(value = "获取权限信息")
    @GetMapping("/roleList")
    public ResponseVo getRoleList(){
        List<fun.mizhuo.hrserver.model.Role> roleList = roleTeamService.getAllRoles();
        return ResponseVo.ok("",roleList);
    }

    @ApiOperation(value = "更新权限信息")
    @PutMapping("/{id}")
    public ResponseVo updateRolesById(@PathVariable Integer id,@RequestBody Integer[] roles){
        List<Role> roleList = hrService.updateRolesById(id,roles);
        return ResponseVo.ok("更新成功!",roleList);
    }

    @ApiOperation(value = "删除HR信息")
    @DeleteMapping("/{id}")
    public ResponseVo deleteHrById(@PathVariable Integer id){
        if(hrService.deleteHrById(id) == 1){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "搜索HR信息")
    @GetMapping("/{keyWord}")
    public ResponseVo searchHrByKeyWord(@PathVariable String keyWord){
        List<Hr> hrs = hrService.searchHrByKeyWord(keyWord);
        return ResponseVo.ok("",hrs);
    }
}
