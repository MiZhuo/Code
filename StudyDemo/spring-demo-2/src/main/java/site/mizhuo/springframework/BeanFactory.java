package site.mizhuo.springframework;

/**
 * @InterfaceName BeanFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-24 14:24
 * @Version 1.0
 **/
public interface BeanFactory {
    Object getBean(String name);
}
