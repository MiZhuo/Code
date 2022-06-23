package site.mizhuo.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Meal
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 18:02
 * @Version 1.0
 **/
public class Meal {

    private List<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public float getCost() {
        return itemList.stream().map(Item::price).reduce(Float::sum).get();
    }

    public void showItems(){
        itemList.forEach(item -> System.out.println("项目:" + item.name() + ",包装:" + item.packing().pack() + ",单价:" + item.price()));
    }
}
