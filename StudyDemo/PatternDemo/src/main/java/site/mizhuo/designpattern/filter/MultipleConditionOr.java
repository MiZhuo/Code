package site.mizhuo.designpattern.filter;

import java.util.List;

/**
 * @ClassName MultipleConditionOr
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-03 21:41
 * @Version 1.0
 **/
public class MultipleConditionOr implements CriteriaPhones{
    private CriteriaPhones criteriaPhones1;
    private CriteriaPhones criteriaPhones2;

    public MultipleConditionOr(CriteriaPhones criteriaPhones1, CriteriaPhones criteriaPhones2) {
        this.criteriaPhones1 = criteriaPhones1;
        this.criteriaPhones2 = criteriaPhones2;
    }

    @Override
    public List<Phone> filterPhones(List<Phone> phones) {
        List<Phone> phones1 = criteriaPhones1.filterPhones(phones);
        List<Phone> phones2 = criteriaPhones2.filterPhones(phones);
        phones1.forEach(p -> {
            if(!phones2.contains(p)){
                phones2.add(p);
            }
        });
        return phones2;
    }
}
