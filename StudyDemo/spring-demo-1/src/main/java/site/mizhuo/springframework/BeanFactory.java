package site.mizhuo.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName BeanFactory
 * @Description: Bean工厂，存放及获取Bean的信息
 * @Author: MiZhuo
 * @Create: 2021-09-23 22:22
 * @Version 1.0
 **/
public class BeanFactory {
    Map<String,BeanDefinition> beanMap = new ConcurrentHashMap<String,BeanDefinition>();

    public Object getBean(String name){
        return beanMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition definition){
        beanMap.put(name, definition);
    }
}
