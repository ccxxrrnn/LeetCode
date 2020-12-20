package DFS.String.LetterCombinations;

import java.util.*;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 10:06
 **/

//17. 电话号码的字母组合
public class Test {



    private  List<String> result;
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        result=new ArrayList<>();
        if (digits.length() == 0){
            return result;
        }
        reBack(digits,map,0,"");
        return result;
    }

    private void reBack(String digits, Map<Integer, String> map, int i, String s) {
        if (i == digits.length()){
            result.add(s);
            return;
        }
        String str = map.get(Integer.parseInt(digits.substring(i, i+1)));
        for (int m = 0;m < str.length() ; m++){
            reBack(digits, map,i+1 , s+str.charAt(m));
        }
    }


}
