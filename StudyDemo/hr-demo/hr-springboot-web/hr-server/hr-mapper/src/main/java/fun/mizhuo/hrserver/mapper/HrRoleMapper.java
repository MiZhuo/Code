package fun.mizhuo.hrserver.mapper;


import fun.mizhuo.hrserver.model.Role;

import java.util.List;
import java.util.Map;

public interface HrRoleMapper {
    void deleteRolesById(Integer id);

    Integer addRolesById(Map<String,Object> params);

    List<Role> getRolesById(Integer id);
}