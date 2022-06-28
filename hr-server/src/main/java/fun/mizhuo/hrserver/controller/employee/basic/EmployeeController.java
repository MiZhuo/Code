package fun.mizhuo.hrserver.controller.employee.basic;

import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.exception.HrException;
import fun.mizhuo.hrserver.model.Employee;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.employee.basic.EmployeeService;
import fun.mizhuo.hrserver.util.PoiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/14 9:47 下午
 * @description: 员工资料Controller
 */
@Api(value = "员工管理Controller",tags = {"员工管理接口"})
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "获取所有员工信息")
    @PostMapping("/getAll")
    public ResponseVo getAllEmp(@RequestParam Map<String,Object> params){
        PageInfo<Employee> data = employeeService.getAllEmp(params);
        return ResponseVo.ok("",data);
    }

    @ApiOperation(value = "高级搜索")
    @PostMapping("/advSearch")
    public ResponseVo advSearch(@RequestBody Map<String, Object> params){
        PageInfo<Employee> data = employeeService.advSearch(params);
        return ResponseVo.ok("",data);
    }

    @ApiOperation(value = "获取员工号")
    @GetMapping("/getWorkId")
    public ResponseVo getNewWorkId(){
        String workId = employeeService.getNewWorkId();
        return ResponseVo.ok("",workId);
    }

    @ApiOperation(value = "保存员工信息")
    @PostMapping("/")
    public ResponseVo saveEmployee(@RequestBody Employee employee){
        boolean flag = employeeService.checkEmployeeIsExist(employee);
        Long contract = Math.abs(employee.getEndContract().getTime() - employee.getBeginContract().getTime()) / (1000 * 60 * 60 * 24);
        employee.setContractTerm(contract * 1.00 / 365);
        if(flag){
            if(employeeService.updateEmployee(employee) > 0) {
                return ResponseVo.ok("更新员工资料成功");
            }
            return ResponseVo.error("更新员工资料失败");
        }else {
            employee.setWorkState("在职");
            employeeService.addEmployee(employee);
            return ResponseVo.ok("建档成功,员工号为" + employee.getWorkId());
        }
    }

    @ApiOperation(value = "删除员工")
    @DeleteMapping("/{id}")
    public ResponseVo deleteEmployee(@PathVariable String id){
        if(employeeService.deleteEmployee(id) > 0){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "批量删除员工")
    @DeleteMapping("/deleteMore")
    public ResponseVo deleteMore(@RequestBody List<Employee> employees){
        if(employeeService.deleteMore(employees) > 0){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败");
    }

    @ApiOperation(value = "导出员工信息")
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportEmployeeData() throws HrException {
        List<Employee> employees = employeeService.getAllEmp();
        return PoiUtils.list2Excel(employees,Employee.class,"员工信息表");
    }

    @ApiOperation(value = "导入员工信息",notes = "务必保证模板正确!")
    @PostMapping("/import")
    public ResponseVo importEmployeeData(MultipartFile file) throws HrException {
        List<Employee> employees = (List<Employee>) PoiUtils.excel2List(file,Employee.class);
        if(employees.isEmpty()){
            return ResponseVo.error("解析无数据,请检查!");
        }
        Integer count = employeeService.saveEmployees(employees);
        if(count > 0){
            return ResponseVo.ok("导入成功!");
        }
        return ResponseVo.error("导入失败!");
    }
}
