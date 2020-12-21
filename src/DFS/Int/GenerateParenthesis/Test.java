package DFS.Int.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 15:21
 **/

//22. 括号生成
public class Test {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(res,n,n,"");
        return res;
    }

    private void dfs(List<String> res, int m, int n, String s) {
        if (m == 0 && n == 0){
            res.add(s);
        }
        if (m > n) return;
        if (m > 0){
            dfs(res, m - 1, n, s + "(");
        }
        if (n > 0){
            dfs(res, m, n - 1, s + ")");
        }
    }


}
