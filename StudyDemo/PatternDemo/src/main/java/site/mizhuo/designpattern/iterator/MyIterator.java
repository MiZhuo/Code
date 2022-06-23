package site.mizhuo.designpattern.iterator;

/**
 * @ClassName MyCollection
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 18:22
 * @Version 1.0
 **/
public class MyIterator implements Iterator{

    private Collection collection;

    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if(pos > 0){
            pos --;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if(pos < collection.size() - 1){
            pos ++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(pos < collection.size() - 1){
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        return collection.get(0);
    }

    @Override
    public Object last() {
        return collection.get(collection.size() - 1);
    }
}
