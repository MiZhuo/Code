package fun.mizhuo.hrserver.service.common;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/19 9:20 下午
 * @description: 公共服务接口类
 */
public interface CommonService {
    List<Map<String,String>> getDropDownList(String code);
}
