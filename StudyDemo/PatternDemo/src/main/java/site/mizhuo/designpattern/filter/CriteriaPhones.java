package site.mizhuo.designpattern.filter;

import java.util.List;

/**
 * @InterfaceName CriteriaPhones
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-03 21:25
 * @Version 1.0
 **/
public interface CriteriaPhones {
    public List<Phone> filterPhones(List<Phone> phones);
}
