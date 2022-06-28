package fun.mizhuo.hrserver.service.employee.basic;

import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/14 10:11 下午
 * @description: 员工服务接口类
 */
public interface EmployeeService {
    PageInfo<Employee> getAllEmp(Map<String,Object> params);

    List<Employee> getAllEmp();

    String getNewWorkId();

    void addEmployee(Employee employee);

    int deleteEmployee(String id);

    boolean checkEmployeeIsExist(Employee employee);

    int updateEmployee(Employee employee);

    Integer saveEmployees(List<Employee> employees);

    PageInfo<Employee> advSearch(Map<String, Object> params);

    Integer deleteMore(List<Employee> employees);
}
