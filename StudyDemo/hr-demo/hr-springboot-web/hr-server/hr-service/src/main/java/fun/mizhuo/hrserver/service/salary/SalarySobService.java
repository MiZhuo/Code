package fun.mizhuo.hrserver.service.salary;

import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.model.Salary;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/10/22 8:12 下午
 * @description: 工资账套服务类
 */
public interface SalarySobService {
    PageInfo<Salary> getAllSalaries(Map<String, Object> params);

    int addSalary(Salary salary);

    int deleteSalaryById(Integer id);

    int deleteMoreSalaries(List<Salary> salaries);

    int updateSalary(Salary salary);
}
