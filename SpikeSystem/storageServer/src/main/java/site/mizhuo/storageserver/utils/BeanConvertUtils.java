package site.mizhuo.storageserver.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName BeanConvertUtils
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 17:41
 * @Version 1.0
 **/
public class BeanConvertUtils {

    public static final <T> T copyProperties(Object source, Class<T> targetClass) {
        try {
            if (source == null || targetClass == null) {
                return null;
            }
            T doInstance = targetClass.newInstance();
            BeanUtils.copyProperties(source, doInstance);
            return doInstance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final <T> List<T> copyProperties(List<?> source, Class<T> targetClass) {
        if(source.isEmpty() || targetClass == null){
            return null;
        }
        List<T> targetList = new ArrayList<>();
        Iterator iterator = source.iterator();
        while (iterator.hasNext()){
            targetList.add(copyProperties(iterator.next(),targetClass));
        }
        return targetList;
    }
}
