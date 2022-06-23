package site.mizhuo.springframework.config;

/**
 * @InterfaceName SingletonBeanRegistry
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:25
 * @Version 1.0
 **/
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
