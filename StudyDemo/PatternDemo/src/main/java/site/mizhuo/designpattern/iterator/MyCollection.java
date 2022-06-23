package site.mizhuo.designpattern.iterator;

/**
 * @ClassName MyCollection
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 18:28
 * @Version 1.0
 **/
public class MyCollection implements Collection{
    public String arr[] = {"A","B","C","D","E"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return arr[i];
    }

    @Override
    public int size() {
        return arr.length;
    }
}
