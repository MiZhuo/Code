package fun.mizhuo.hrserver.util;

import fun.mizhuo.hrserver.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: Mizhuo
 * @time: 2020/9/13 11:17 上午
 * @description: Hr工具类
 */
public class HrUtils {
    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
