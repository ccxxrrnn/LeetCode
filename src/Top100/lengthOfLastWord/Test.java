package Top100.lengthOfLastWord;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-02 10:05
 */

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int lengthOfLastWord(String s) {
        String[] arrS=s.split(" ");
        Stack<String> stack=new Stack<>();
        stack.addAll(Arrays.asList(arrS));
        while (!stack.isEmpty()){
            String str=stack.pop();
            for (int i=0;i<str.length();i++){
                if(str.charAt(i)>'z' && str.charAt(i)<'A'){
                    break;
                }
                if (i==str.length()-1) return i+1;
            }
        }
        return 0;
    }
}
