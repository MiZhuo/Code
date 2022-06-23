package site.mizhuo.code;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Create by wulibin on 2019/6/1
 *
 * @description Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
         * 这里是为了排除endWord不在wordList中的情况，不然下面遍历的时候endWord变化一位就
         * 在wordList中了。
         */
        if (!wordList.contains(endWord)) {
            return 0;
        }
        /*
         * bfs就是把每次筛选出来的节点保存到一个Set中，然后再次逐个遍历
         */
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (beginSet.size() > 0) {
            for (String b : beginSet) {
                wordList.remove(b);
            }
            step++;
            Set<String> tempSet = new HashSet<>();
            for (String b : beginSet) {
                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String w = iterator.next();
                    if (diff(b, w) > 1) {
                        continue;
                    } else {
                        if (endSet.contains(w)) {
                            return step;
                        } else {
                            tempSet.add(w);
                            /*
                             * 本来想提前遍历删除的，结果失败了
                             * 这里也要注意，在遍历List的时候删除有两种办法：
                             * 1. iterator 这里采用此种方法
                             * 2. 倒序遍历删除
                             */
//                            wordList.remove(w);
//                            iterator.remove();
                        }
                    }
                }
            }
            /*
             * 这里的tempSet其实是nextBeginSet, 判断一下从哪边走简单就从哪边走
             */
            if (tempSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = tempSet;
            } else {
                beginSet = tempSet;
            }
        }
        return 0;
    }

    private int diff(String w1, String w2) {
        int deviation = 0;
        for (int i = 0; i < w1.length() && deviation < 2; ++i) {
            if (w1.charAt(i) != w2.charAt(i)) {
                ++deviation;
            }
        }
        return deviation;
    }
}
