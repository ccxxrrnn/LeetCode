package Stack.String.isValid;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-18 11:47
 */

public class Test {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int lenS = s.length();
        if ((s.length() & 1) == 1) return false;
        HashMap<Character,Character> hashMap = new HashMap<Character,Character>(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        for (char c : s.toCharArray()){
            if (hashMap.containsKey(c)){
                stack.push(c);
            }else if(stack.isEmpty() || hashMap.get(stack.pop()) != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
