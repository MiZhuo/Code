package fun.mizhuo.hrserver.service.impl.common;

import fun.mizhuo.hrserver.mapper.MenuMapper;
import fun.mizhuo.hrserver.model.Hr;
import fun.mizhuo.hrserver.model.Menu;
import fun.mizhuo.hrserver.service.common.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/8/23 11:11 上午
 * @description: 菜单服务实现类
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> initMenuByUserId() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.initMenuByUserId(hr.getId());
    }

    @Override
    public List<Menu> getMenuWithRole(){
        return menuMapper.getMenuWithRole();
    }

    @Override
    public List<Menu> getMenuTree() {
        return menuMapper.getMenuTree();
    }

}
