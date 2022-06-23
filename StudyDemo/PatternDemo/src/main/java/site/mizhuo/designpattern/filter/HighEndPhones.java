package site.mizhuo.designpattern.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName HighEndPhones
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-03 21:52
 * @Version 1.0
 **/
public class HighEndPhones implements CriteriaPhones{

    @Override
    public List<Phone> filterPhones(List<Phone> phones) {
        return phones.stream().filter(p -> p.getPrice() > 8888).collect(Collectors.toList());
    }
}
