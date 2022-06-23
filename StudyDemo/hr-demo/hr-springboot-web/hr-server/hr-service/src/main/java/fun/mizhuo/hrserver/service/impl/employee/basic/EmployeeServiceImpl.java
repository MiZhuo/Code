package fun.mizhuo.hrserver.service.impl.employee.basic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.mizhuo.hrserver.mapper.EmployeeMapper;
import fun.mizhuo.hrserver.model.Employee;
import fun.mizhuo.hrserver.service.employee.basic.EmployeeService;
import fun.mizhuo.hrserver.util.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/14 10:12 下午
 * @description: 员工服务接口实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public PageInfo<Employee> getAllEmp(Map<String,Object> params) {
        Integer pageNum = MapUtils.getIntegerValue(params,"pageNum",1);
        Integer pageSize = MapUtils.getIntegerValue(params,"pageSize",10);
        String orderField = MapUtils.getStringValue(params,"orderField","");
        String sortType = MapUtils.getStringValue(params,"sortType","");
        if(StringUtils.isEmpty(orderField) || StringUtils.isEmpty(sortType)){
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->employeeMapper.getAllEmp(params));
        }else {
            String orderBy = orderField + " " + sortType;
            return PageHelper.startPage(pageNum, pageSize, orderBy).doSelectPageInfo(() -> employeeMapper.getAllEmp(params));
        }
    }

    @Override
    public PageInfo<Employee> advSearch(Map<String, Object> params) {
        Integer pageNum = MapUtils.getIntegerValue(params,"pageNum",10);
        Integer pageSize = MapUtils.getIntegerValue(params,"pageSize",10);
        String orderField = MapUtils.getStringValue(params,"orderField","");
        String sortType = MapUtils.getStringValue(params,"sortType","");
        if(StringUtils.isEmpty(orderField) || StringUtils.isEmpty(sortType)){
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->employeeMapper.advSearch(params));
        }else {
            String orderBy = orderField + " " + sortType;
            return PageHelper.startPage(pageNum, pageSize, orderBy).doSelectPageInfo(() -> employeeMapper.advSearch(params));
        }
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeMapper.getAllEmp(new HashMap<>());
    }

    @Override
    public String getNewWorkId() {
        return employeeMapper.getNewWorkId();
    }

    @Override
    public void addEmployee(Employee employee) {
        if(StringUtils.isEmpty(employee.getWorkId())){
            employee.setWorkId(this.getNewWorkId());
        }
        employeeMapper.addEmployee(employee);
        logger.info("添加员工成功,开始发送入职邮件!");
        //发送入职邮件
        rabbitTemplate.convertAndSend("mizhuo.mail",employee);
    }

    @Override
    public int deleteEmployee(String id) {
        return employeeMapper.deleteEmployee(id);
    }

    @Override
    public Integer deleteMore(List<Employee> employees) {
        return employeeMapper.deleteMore(employees);
    }

    @Override
    public boolean checkEmployeeIsExist(Employee employee) {
        return employeeMapper.checkEmployeeIsExist(employee) > 0;
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public Integer saveEmployees(List<Employee> employees) {
        return employeeMapper.saveEmployees(employees);
    }
}
