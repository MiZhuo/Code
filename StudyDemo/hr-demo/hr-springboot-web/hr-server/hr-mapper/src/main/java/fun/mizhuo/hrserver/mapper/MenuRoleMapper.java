package fun.mizhuo.hrserver.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author mizhuo
 */
public interface MenuRoleMapper {
    List<Integer> getMenuIdsByRoleId(Integer id);

    void deleteMenuByRoleId(int roleId);

    int insertMenuWithRoleId(Map<String,Object> params);
}