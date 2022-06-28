package fun.mizhuo.hrserver.config;

import fun.mizhuo.hrserver.enums.NoneRoleURLEnum;
import fun.mizhuo.hrserver.model.Menu;
import fun.mizhuo.hrserver.model.Role;
import fun.mizhuo.hrserver.service.common.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/8/26 10:42 下午
 * @description: 根据用户请求地址分析出请求需要的角色
 */
@Component
public class RoleFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher matcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //符合放行规则的url,置为NONE权限
        if(NoneRoleURLEnum.checkRole(requestUrl)){
            return SecurityConfig.createList("ROLE_NONE");
        }
        List<Menu> menus = menuService.getMenuWithRole();
        for (Menu menu : menus){
            if(matcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < str.length; i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        //未匹配到的，登录便可以访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
