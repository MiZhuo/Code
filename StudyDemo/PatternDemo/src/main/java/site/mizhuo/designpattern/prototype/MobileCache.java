package site.mizhuo.designpattern.prototype;

import java.util.Hashtable;

/**
 * @ClassName MobileCache
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-30 21:56
 * @Version 1.0
 **/
public class MobileCache {
    private static Hashtable<String,Mobile> cache = new Hashtable<>();

    public static Mobile getMobile(String mId){
        Mobile mobile = cache.get(mId);
        if(mobile != null){
            return (Mobile) mobile.clone();
        }
        return null;
    }

    /***
     * @Author MiZhuo
     * @Description 缓存数据
     * @Date 10:07 下午 2021/8/30
     * @Param []
     * @return void
     **/
    public static void loadCache(){
        ApplePhone apple = new ApplePhone();
        apple.setName("apple");
        cache.put(apple.getName(),apple);

        HuaWeiPhone huawei = new HuaWeiPhone();
        huawei.setName("huawei");
        cache.put(huawei.getName(),huawei);

        XiaoMiPhone xiaomi = new XiaoMiPhone();
        xiaomi.setName("xiaomi");
        cache.put(xiaomi.getName(),xiaomi);
    }
}
