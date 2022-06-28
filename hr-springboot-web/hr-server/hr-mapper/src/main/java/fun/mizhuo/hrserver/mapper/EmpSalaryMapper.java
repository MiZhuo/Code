package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.EmpSalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpSalaryMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(EmpSalary record);
//
//    int insertSelective(EmpSalary record);
//
//    EmpSalary selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(EmpSalary record);
//
//    int updateByPrimaryKey(EmpSalary record);

    List<Map<String, Object>> getAllEmpSalaries(Map<String, Object> params);

    int changeSalary(@Param("id")Integer id, @Param("salaryId")Integer salaryId);

    int addSalary( @Param("empId")Integer empId, @Param("salaryId")Integer salaryId);
}