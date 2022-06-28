package fun.mizhuo.hrserver.util;

import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/20 3:05 下午
 * @description: Map工具类
 */
public class MapUtils {
    /**
     * 获取Map中String字符串
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringValue(Map<String,Object> map,String key,String defaultValue){
        String value = String.valueOf(map.get(key));
        return (value == null || "".equals(value)) ? defaultValue : value;
    }

    /**
     * 获取Map中Integer数据
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    public static Integer getIntegerValue(Map<String,Object> map,String key,Integer defaultValue){
        String value = String.valueOf(map.get(key));
        return (value == null || "".equals(value)) ? defaultValue : Integer.valueOf(value);
    }
}
