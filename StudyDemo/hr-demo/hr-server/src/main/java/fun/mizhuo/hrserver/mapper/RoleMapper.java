package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> getAllRoles();

    int addRole(Role role);

    Integer deleteRoleByRoleId(Integer roleId);

    List<Role> getRolesByHrId(Integer id);
}