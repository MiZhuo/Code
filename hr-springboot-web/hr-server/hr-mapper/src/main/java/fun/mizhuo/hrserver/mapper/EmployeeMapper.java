package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<Employee> getAllEmp(Map<String,Object> params);

    String getNewWorkId();

    void addEmployee(Employee employee);

    int deleteEmployee(String id);

    int checkEmployeeIsExist(Employee employee);

    int updateEmployee(Employee employee);

    Integer saveEmployees(List<Employee> employees);

    List<Employee> advSearch(Map<String, Object> params);

    Integer deleteMore(List<Employee> employees);
}