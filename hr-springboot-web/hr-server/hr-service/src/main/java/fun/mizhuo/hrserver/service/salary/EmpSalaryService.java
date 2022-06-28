package fun.mizhuo.hrserver.service.salary;

import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.model.EmpSalary;

import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/10/25 11:24 上午
 * @description: 员工账套服务类
 */
public interface EmpSalaryService {
    PageInfo<Map<String, Object>> getAllEmpSalaries(Map<String,Object> params);

    int changeSalary(Integer id, Integer salaryId);

    int addSalary(Integer empId, Integer salaryId);
}
