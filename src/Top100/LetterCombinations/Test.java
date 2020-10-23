package Top100.LetterCombinations;

import java.util.*;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 10:06
 **/

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Test t = new Test();
        String input="";
        List<String> out=t.letterCombinations(input);
        System.out.println(out.toString());
    }

    private  List<String> result;
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map=new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if (digits.length()==0){
            return null;
        }
        result=new ArrayList<>();
        reBack(digits,map,0,"");
        return result;
    }

    private void reBack(String digits, Map<Integer, String> map, int i, String s) {
        if (i==digits.length()){
            result.add(s);
            return;
        }
        String str=map.get(Integer.parseInt(digits.substring(i, i+1)));
        for (int m=0;m<str.length();m++){
            reBack(digits, map,i+1 , s+str.charAt(m));
        }
    }


}
