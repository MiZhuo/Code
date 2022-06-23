package site.mizhuo.designpattern.iterator;

/**
 * @ClassName Collection
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 18:19
 * @Version 1.0
 **/
public interface Collection {
    /***
     * @Author MiZhuo
     * @Description 迭代器
     * @Date 6:22 下午 2021/9/11
     * @Param []
     * @return site.mizhuo.designPattern.iterator.Iterator
     **/
    Iterator iterator();

    /***
     * @Author MiZhuo
     * @Description 获取元素
     * @Date 6:22 下午 2021/9/11
     * @Param [i]
     * @return java.lang.Object
     **/
    Object get(int i);


    /***
     * @Author MiZhuo
     * @Description 返回集合大小
     * @Date 6:22 下午 2021/9/11
     * @Param []
     * @return int
     **/
    int size();
}
