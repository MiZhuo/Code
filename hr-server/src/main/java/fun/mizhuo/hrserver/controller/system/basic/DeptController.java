package fun.mizhuo.hrserver.controller.system.basic;

import fun.mizhuo.hrserver.model.Department;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.system.basic.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/12 3:21 下午
 * @description: 部门Controller
 */
@Api(value = "部门Controller",tags = {"部门管理接口"})
@RestController
@RequestMapping("/system/basic/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @ApiOperation(value = "获取部门树")
    @GetMapping("/deptTree")
    public ResponseVo getDeptTree(){
        List<Department> departments = deptService.getDeptTree();
        return ResponseVo.ok("",departments);
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/")
    public ResponseVo addDept(@RequestBody Department department){
        deptService.addDept(department);
        if( department.getResult()== 1){
            return ResponseVo.ok("添加成功",department);
        }
        return ResponseVo.error("添加失败!");
    }

    @ApiOperation(value = "根据ID删除部门")
    @DeleteMapping("/{id}")
    public ResponseVo deleteDept(@PathVariable Integer id){
        Department department = new Department();
        department.setId(id);
        deptService.deleteDept(department);
        if( department.getResult() == -2){
            return ResponseVo.error("该部门下有子部门,删除失败!");
        }else if( department.getResult() == -1){
            return ResponseVo.error("该部门下有员工,删除失败!");
        }else if( department.getResult() == 1){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }
}
