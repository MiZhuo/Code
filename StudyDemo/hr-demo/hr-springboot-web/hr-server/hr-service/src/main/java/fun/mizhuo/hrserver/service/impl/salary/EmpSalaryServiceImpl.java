package fun.mizhuo.hrserver.service.impl.salary;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.mapper.EmpSalaryMapper;
import fun.mizhuo.hrserver.service.salary.EmpSalaryService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/10/25 11:24 上午
 * @description: 员工账套服务实现类
 */
@Service
public class EmpSalaryServiceImpl implements EmpSalaryService {

    @Autowired
    EmpSalaryMapper salaryMapper;

    @Override
    public PageInfo<Map<String, Object>> getAllEmpSalaries(Map<String,Object> params) {
        Integer pageNum = MapUtils.getInteger(params,"pageNum",1);
        Integer pageSize = MapUtils.getInteger(params,"pageSize",10);
        String orderField = MapUtils.getString(params,"orderField","");
        String sortType = MapUtils.getString(params,"sortType","");
        if(StringUtils.isEmpty(orderField) || StringUtils.isEmpty(sortType)){
            return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->salaryMapper.getAllEmpSalaries(params));
        }else {
            String orderBy = orderField + " " + sortType;
            return PageHelper.startPage(pageNum, pageSize, orderBy).doSelectPageInfo(() -> salaryMapper.getAllEmpSalaries(params));
        }
    }

    @Override
    public int changeSalary(Integer id, Integer salaryId) {
        return salaryMapper.changeSalary(id,salaryId);
    }

    @Override
    public int addSalary(Integer empId, Integer salaryId) {
        return salaryMapper.addSalary(empId,salaryId);
    }
}
