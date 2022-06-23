package site.mizhuo.code;

import java.util.Stack;

/**
 * @author MiZhuo
 * @Description:
 * 假设我们以下述方式将我们的文件系统抽象成一个字符串:
 *
 * 字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:
 *
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 * 目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。
 *
 * 字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示:
 *
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *             file2.ext
 * 目录 dir 包含两个子目录 subdir1 和 subdir2。 subdir1 包含一个文件 file1.ext 和一个空的二级子目录 subsubdir1。subdir2 包含一个二级子目录 subsubdir2 ，其中包含一个文件 file2.ext。
 *
 * 我们致力于寻找我们文件系统中文件的最长 (按字符的数量统计) 绝对路径。例如，在上述的第二个例子中，最长路径为 "dir/subdir2/subsubdir2/file2.ext"，其长度为 32 (不包含双引号)。
 *
 * 给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
 *
 * 说明:
 *
 * 文件名至少存在一个 . 和一个扩展名。
 * 目录或者子目录的名字不能包含 .。
 * 要求时间复杂度为 O(n) ，其中 n 是输入字符串的大小。
 *
 * 请注意，如果存在路径 aaaaaaaaaaaaaaaaaaaaa/sth.png 的话，那么  a/aa/aaa/file1.txt 就不是一个最长的路径。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-absolute-file-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-08-07 21:44
 */
public class LengthLongestPath{
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了21.57%的用户
     * 内存消耗 :34.8 MB, 在所有 Java 提交中击败了56.25%的用户
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        if(arr.length == 1){
            if(arr[0].contains(".")){
                return arr[0].length();
            }else{
                return 0;
            }
        }else if (arr.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int stackLev = 0;
        int maxSize = 0;
        stack.push(arr[0].length());
        for (int i = 1; i < arr.length; i++) {
            int len = 0;
            String temp = arr[i];
            while (temp.contains("\t")){
                len ++;
                temp = temp.substring(1,temp.length());
            }
            if(len > stackLev){
                stack.push(temp.length());
                stackLev ++;
            }else{
                while (stack.size() > len) {
                    stack.pop();
                    stackLev --;
                }
                stack.push(temp.length());
                stackLev ++;
            }
            if(temp.contains(".")){
                int tempSize = 0;
                for (Integer l : stack) {
                    tempSize += l;
                }
                tempSize = tempSize + stack.size() - 1;
                if(tempSize > maxSize){
                    maxSize = tempSize;
                }
            }
        }
        return maxSize;
    }
}
