package String.Stack.IsValid;

import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 14:50
 **/

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        boolean out=t.isValid("{}");
        System.out.println(out);
    }


    public boolean isValid(String s) {
        if (s.length()==0) return true;
        if (s.length()%2!=0) return false;
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if(compare(stack,s.charAt(i))){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }

    private boolean compare(Stack<Character> stack, char charAt) {
        if (stack.size()==0) return false;
        if (stack.peek()=='(' && charAt==')'){
            return true;
        }
        if (stack.peek()=='[' && charAt==']'){
            return true;
        }
        return stack.peek() == '{' && charAt == '}';
    }
}
