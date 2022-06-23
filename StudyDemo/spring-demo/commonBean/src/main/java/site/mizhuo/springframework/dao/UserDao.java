package site.mizhuo.springframework.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserDao
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-29 21:33
 * @Version 1.0
 **/
public class UserDao {
    private static Map<String,String> map = new HashMap<String,String>();

    static {
        map.put("001","迷浊");
        map.put("002","喵喵");
        map.put("003","橘子精");
    }

    public String queryNameById(String id){
        return map.get(id);
    }
}
