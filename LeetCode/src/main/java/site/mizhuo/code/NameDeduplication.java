package site.mizhuo.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of names, remove the duplicate names. Two name will be treated as the same name if they are equal ignore the case.
 *
 * Return a list of names without duplication, all names should be in lowercase, and keep the order in the original list.
 * Example 1:
 *
 * Input:["James", "james", "Bill Gates", "bill Gates", "Hello World", "HELLO WORLD", "Helloworld"]
 *
 *
 * Output:["james", "bill gates", "hello world", "helloworld"]
 * Example 2:
 *
 * Input:["cmy","Cmy"]
 *
 * Output:["cmy"]
 */
public class NameDeduplication {
    /**
     * @param names: a string array
     * @return: a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // write your code here
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String str : names){
            set.add(str.toLowerCase());
        }
        for(String s : set){
            list.add(s);
        }
        return list;
    }
}
