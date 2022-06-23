package site.mizhuo.designpattern.decorator;

/**
 * @ClassName ImmortalAnimal
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-05 17:17
 * @Version 1.0
 **/
public class ImmortalAnimal extends AnimalWithSoul{

    public ImmortalAnimal(Animal animalWithSoul) {
        super(animalWithSoul);
    }

    @Override
    public void abilities() {
        super.abilities();
        xianshu();
    }

    public void xianshu(){
        System.out.println("新增技能:仙术");
    }
}
