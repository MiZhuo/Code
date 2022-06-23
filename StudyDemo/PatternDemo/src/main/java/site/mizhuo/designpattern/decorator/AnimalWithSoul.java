package site.mizhuo.designpattern.decorator;

/**
 * @ClassName AnimalWithSoul
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-05 17:12
 * @Version 1.0
 **/
public abstract class AnimalWithSoul implements Animal{
    protected Animal animal;

    public AnimalWithSoul(Animal animalWithSoul) {
        this.animal = animalWithSoul;
    }

    @Override
    public void abilities() {
        animal.abilities();
    }
}
