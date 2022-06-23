package site.mizhuo.designpattern.filter;

import java.util.List;

/**
 * @ClassName Iphone12
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-03 21:38
 * @Version 1.0
 **/
public class MultipleConditionAnd implements CriteriaPhones{
    private CriteriaPhones criteriaPhones1;
    private CriteriaPhones criteriaPhones2;

    public MultipleConditionAnd(CriteriaPhones criteriaPhones1, CriteriaPhones criteriaPhones2) {
        this.criteriaPhones1 = criteriaPhones1;
        this.criteriaPhones2 = criteriaPhones2;
    }

    @Override
    public List<Phone> filterPhones(List<Phone> phones) {
        return criteriaPhones2.filterPhones(criteriaPhones1.filterPhones(phones));
    }
}
