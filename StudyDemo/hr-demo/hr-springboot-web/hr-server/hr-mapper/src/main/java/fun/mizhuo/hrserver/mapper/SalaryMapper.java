package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.Salary;

import java.util.List;
import java.util.Map;

public interface SalaryMapper {
    List<Salary> getAllSalaries(Map<String, Object> params);

    int deleteSalaryById(Integer id);

    int deleteMoreSalaries(List<Salary> salaries);

    int addSalary(Salary salary);

    int updateSalary(Salary salary);
}