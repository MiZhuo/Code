package fun.mizhuo.hrserver.service.impl.system.basic;

import fun.mizhuo.hrserver.mapper.DepartmentMapper;
import fun.mizhuo.hrserver.model.Department;
import fun.mizhuo.hrserver.service.system.basic.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/12 3:30 下午
 * @description: 部门服务实现类
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDeptTree() {
        return departmentMapper.getDeptTree(-1);
    }

    @Override
    public void addDept(Department department) {
        department.setEnabled(true);
        departmentMapper.addDept(department);
    }

    @Override
    public void deleteDept(Department department) {
        departmentMapper.deleteDept(department);
    }
}
