package fun.mizhuo.hrserver.service.common;


import fun.mizhuo.hrserver.model.Menu;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/8/23 11:08 上午
 * @description: 菜单服务接口类
 */
public interface MenuService {
    List<Menu> initMenuByUserId();

    List<Menu> getMenuWithRole();

    List<Menu> getMenuTree();
}
