package fun.mizhuo.hrserver.service.system.basic;

import fun.mizhuo.hrserver.model.Role;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/11 19:09 下午
 * @description: 权限组服务接口类
 */
public interface RoleTeamService {
    List<Role> getAllRoles();

    Integer addRole(Role role);

    Integer deleteRoleByRoleId(Integer roleId);
}
