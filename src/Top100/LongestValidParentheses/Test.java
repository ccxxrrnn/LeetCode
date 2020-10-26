package Top100.LongestValidParentheses;

import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-26 15:30
 **/

/**
 * 给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.longestValidParentheses("())(())((()))");
        System.out.println(res);
    }


    public int longestValidParentheses(String s) {
        //用栈存储位置，假如‘（’就进栈，（判断栈顶）
        // 如果‘）‘就出栈,判断栈顶是否为空，为空就放值，
        int max=0;
        Stack<Integer> judsatack=new Stack<>();
        judsatack.push(-1); //
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                judsatack.push(i);
            }else{
                judsatack.pop();
                if (judsatack.isEmpty()){
                    judsatack.push(i);
                }else{
                    max=Math.max(max,i-judsatack.peek());
                }
            }
        }
        return max;
    }
}
