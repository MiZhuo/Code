package fun.mizhuo.hrserver.controller.salary.salsob;

import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.model.Salary;
import fun.mizhuo.hrserver.service.salary.SalarySobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/10/22 7:46 下午
 * @description: 工资账套Controller
 */
@Api(value = "工资账套Controller",tags = {"工资账套管理接口"})
@RestController
@RequestMapping("/salary/sob")
public class SalarySobController {

    @Autowired
    SalarySobService salarySobService;

    @ApiOperation(value = "获取所有工资账套信息")
    @PostMapping("/getAll")
    public ResponseVo getAllSalaries(@RequestParam Map<String,Object> params){
        PageInfo<Salary> data = salarySobService.getAllSalaries(params);
        return ResponseVo.ok("",data);
    }

    @ApiOperation(value = "保存工资账套信息")
    @PostMapping("/")
    public ResponseVo saveSalary(@RequestBody Salary salary){
        salary.setCreateDate(new Date());
        if(salary.getId() != null){
            if (salarySobService.updateSalary(salary) > 0) {
                return ResponseVo.ok("修改成功!");
            }
            return ResponseVo.error("修改失败!");
        }else {
            if (salarySobService.addSalary(salary) > 0) {
                return ResponseVo.ok("添加成功!");
            }
            return ResponseVo.error("添加失败!");
        }
    }

    @ApiOperation(value = "删除工资账套信息")
    @DeleteMapping("/{id}")
    public ResponseVo deleteSalaryById(@PathVariable Integer id){
        if(salarySobService.deleteSalaryById(id) > 0){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "删除工资账套信息")
    @DeleteMapping("/")
    public ResponseVo deleteMoreSalaries(@RequestBody List<Salary> salaries){
        if(salarySobService.deleteMoreSalaries(salaries) > 0){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败");
    }
}
