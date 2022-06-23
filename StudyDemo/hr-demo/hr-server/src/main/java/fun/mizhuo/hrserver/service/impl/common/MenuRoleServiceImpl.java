package fun.mizhuo.hrserver.service.impl.common;

import fun.mizhuo.hrserver.mapper.MenuRoleMapper;
import fun.mizhuo.hrserver.service.common.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/11 8:17 下午
 * @description: 菜单权限服务实现类
 */
@Service
public class MenuRoleServiceImpl implements MenuRoleService {
    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Override
    public Integer[] getMenuIdsByRoleId(Integer id) {
        List<Integer> mIds = menuRoleMapper.getMenuIdsByRoleId(id);
        return mIds.toArray(new Integer[mIds.size()]);
    }

    @Override
    @Transactional
    public Integer modifyMenuByRoleId(int roleId,Integer[] menuIds) {
        Integer resultCount = 0;
        menuRoleMapper.deleteMenuByRoleId(roleId);
        if(menuIds.length > 0) {
            Map<String, Object> params = new HashMap<>();
            params.put("roleId", roleId);
            params.put("menuIds", menuIds);
            resultCount = menuRoleMapper.insertMenuWithRoleId(params);
        }
        return resultCount;
    }
}
