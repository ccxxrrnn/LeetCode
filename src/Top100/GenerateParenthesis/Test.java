package Top100.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 15:21
 **/

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        List<String> list=t.generateParenthesis(3);
        System.out.println(list.toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        if (n==0) return result;
        doSelect(result, n, n ,"");
        return result;
    }

    private void doSelect(List<String> result, int i, int j, String s){
        if (i==0 && j==0){
            result.add(s);
            return;
        }
        if (i>j)
        {
            return;
        }
        if (i>0){
            doSelect(result, i-1, j, s+"(");
        }
        if (j>0){
            doSelect(result, i, j - 1,s+")");
        }
    }

}
