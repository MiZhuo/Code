package fun.mizhuo.hrserver.service.system.basic;

import fun.mizhuo.hrserver.model.Department;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/12 3:29 下午
 * @description: 部门服务接口类
 */
public interface DeptService {
    List<Department> getDeptTree();

    void addDept(Department department);

    void deleteDept(Department department);
}
