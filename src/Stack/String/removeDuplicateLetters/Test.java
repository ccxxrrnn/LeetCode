package Stack.String.removeDuplicateLetters;

import java.util.Stack;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-20 12:02
 */

//316. 去除重复字母
//栈
public class Test {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int lenS = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < lenS ; i++){
            if (stack.isEmpty()){
                stack.push(chars[i]);
            }
            if (stack.contains(chars[i])){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > chars[i]){
                int j ;
                for (j = i + 1 ; j < lenS ; j++){
                    if (chars[j] == stack.peek()){
                        stack.pop();
                        break;
                    }
                }
                if (j == lenS) break;
            }
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
