package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> initMenuByUserId(Integer id);

    List<Menu> getMenuWithRole();

    List<Menu> getMenuTree();
}