package fun.mizhuo.hrserver.service.common;


/**
 * @author: Mizhuo
 * @time: 2020/9/11 8:17 下午
 * @description: 菜单权限服务接口类
 */
public interface MenuRoleService {
    Integer[] getMenuIdsByRoleId(Integer id);

    Integer modifyMenuByRoleId(int roleId,Integer[] menuIds);
}
