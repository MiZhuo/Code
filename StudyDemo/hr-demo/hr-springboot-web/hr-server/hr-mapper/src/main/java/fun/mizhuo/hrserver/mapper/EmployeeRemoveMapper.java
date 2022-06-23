package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.EmployeeRemove;

public interface EmployeeRemoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRemove record);

    int insertSelective(EmployeeRemove record);

    EmployeeRemove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeRemove record);

    int updateByPrimaryKey(EmployeeRemove record);
}