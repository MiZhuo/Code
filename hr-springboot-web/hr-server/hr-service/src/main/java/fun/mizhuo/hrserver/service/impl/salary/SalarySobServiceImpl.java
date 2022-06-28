package fun.mizhuo.hrserver.service.impl.salary;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.mapper.SalaryMapper;
import fun.mizhuo.hrserver.model.Salary;
import fun.mizhuo.hrserver.service.salary.SalarySobService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/10/22 8:13 下午
 * @description: 工资账套服务实现类
 */
@Service
public class SalarySobServiceImpl implements SalarySobService {

    @Autowired
    SalaryMapper salaryMapper;

    @Override
    public PageInfo<Salary> getAllSalaries(Map<String, Object> params) {
        Integer pageNum = MapUtils.getInteger(params,"pageNum",1);
        Integer pageSize = MapUtils.getInteger(params,"pageSize",10);
        String orderField = MapUtils.getString(params,"orderField","");
        String sortType = MapUtils.getString(params,"sortType","");
        if(StringUtils.isEmpty(orderField) || StringUtils.isEmpty(sortType)){
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->salaryMapper.getAllSalaries(params));
        }else {
            String orderBy = orderField + " " + sortType;
            return PageHelper.startPage(pageNum, pageSize, orderBy).doSelectPageInfo(() -> salaryMapper.getAllSalaries(params));
        }
    }

    @Override
    public int addSalary(Salary salary) {
        return salaryMapper.addSalary(salary);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    @Override
    public int deleteSalaryById(Integer id) {
        return salaryMapper.deleteSalaryById(id);
    }

    @Override
    public int deleteMoreSalaries(List<Salary> salaries) {
        return salaryMapper.deleteMoreSalaries(salaries);
    }
}
