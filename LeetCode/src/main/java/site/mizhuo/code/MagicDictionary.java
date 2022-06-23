package site.mizhuo.code;

/**
 * @author MiZhuo
 * @Description:
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
 *
 * 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
 *
 * 对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 示例 1:
 *
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * 注意:
 *
 * 你可以假设所有输入都是小写字母 a-z。
 * 为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
 * 请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-magic-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-27 21:06
 */
public class MagicDictionary {
    private String[] dict = null;
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        this.dict = dict;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(this.dict == null){
            return false;
        }
        boolean flag = false;
        for (String target : dict){
            if(word.length() != target.length()){
                continue;
            }else{
                int iLoop = 0;
                for (int i = 0; i < target.length();i++){
                    if(target.charAt(i) != word.charAt(i)){
                        iLoop++;
                    }
                }
                if(iLoop == 1){
                    flag = true;
                }
            }
        }
        return flag;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
