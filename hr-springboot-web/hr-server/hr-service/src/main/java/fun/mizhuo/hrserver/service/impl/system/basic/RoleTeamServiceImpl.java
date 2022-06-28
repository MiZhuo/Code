package fun.mizhuo.hrserver.service.impl.system.basic;

import fun.mizhuo.hrserver.mapper.RoleMapper;
import fun.mizhuo.hrserver.model.Role;
import fun.mizhuo.hrserver.service.system.basic.RoleTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/11 7:09 下午
 * @description: 权限组服务实现类
 */
@Service
public class RoleTeamServiceImpl implements RoleTeamService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public Integer addRole(Role role) {
        String roleName = role.getName();
        role.setName(roleName.startsWith("ROLE_") ? roleName : "ROLE_" + roleName);
        return roleMapper.addRole(role);
    }

    @Override
    public Integer deleteRoleByRoleId(Integer roleId) {
        return roleMapper.deleteRoleByRoleId(roleId);
    }
}
