package fun.mizhuo.hrserver.controller.salary.salsob;

import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.salary.EmpSalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/10/25 11:18 上午
 * @description: 员工工资账套信息
 */
@Api(value = "员工工资账套Controller",tags = {"员工工资账套信息接口"})
@RestController
@RequestMapping("/salary/employee")
public class EmpSalaryController {

    @Autowired
    EmpSalaryService empSalaryService;

    @ApiOperation("获取所有员工账套信息")
    @PostMapping("/")
    public ResponseVo getAllEmpSalaries(@RequestParam Map<String,Object> params){
        PageInfo<Map<String, Object>> empSalaries = empSalaryService.getAllEmpSalaries(params);
        return ResponseVo.ok("",empSalaries);
    }

    @ApiOperation("添加员工工资账套")
    @PostMapping("/{empId}/{salaryId}")
    public ResponseVo addSalary(@PathVariable Integer empId,@PathVariable Integer salaryId){
        if(empSalaryService.addSalary(empId,salaryId) > 0 ){
            return ResponseVo.ok("添加成功!");
        };
        return ResponseVo.error("添加失败!");
    }

    @ApiOperation("更新员工工资账套")
    @PutMapping("/{id}/{salaryId}")
    public ResponseVo changeSalary(@PathVariable Integer id,@PathVariable Integer salaryId){
        if(empSalaryService.changeSalary(id,salaryId) > 0 ){
            return ResponseVo.ok("更新成功!");
        };
        return ResponseVo.error("更新失败!");
    }
}
