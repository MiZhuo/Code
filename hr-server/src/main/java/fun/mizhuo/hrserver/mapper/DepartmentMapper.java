package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.Department;

import java.util.List;

/**
 * @author mizhuo
 */
public interface DepartmentMapper {
    List<Department> getDeptTree(int i);

    void addDept(Department department);

    void deleteDept(Department department);
}