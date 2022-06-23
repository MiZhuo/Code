package site.mizhuo.designpattern.builder;

/**
 * @ClassName MealBuilder
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 21:12
 * @Version 1.0
 **/
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public Meal prepareChickenMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        return meal;
    }
}
