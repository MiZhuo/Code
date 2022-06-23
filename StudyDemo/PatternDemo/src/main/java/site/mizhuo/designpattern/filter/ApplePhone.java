package site.mizhuo.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ApplePhone
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-03 21:28
 * @Version 1.0
 **/
public class ApplePhone implements CriteriaPhones{
    @Override
    public List<Phone> filterPhones(List<Phone> phones) {
        List<Phone> applePhones = new ArrayList<Phone>();
        phones.forEach(p->{
            if("Apple".equalsIgnoreCase(p.getBrand())){
                applePhones.add(p);
            }
        });
        return applePhones;
    }
}
