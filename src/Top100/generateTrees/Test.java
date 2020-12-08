package Top100.generateTrees;

import Util.PrintUtil;
import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-08 10:43
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        return dfs(1,n);  //开始  结束
    }

    private List<TreeNode> dfs(int m, int n) {
        List<TreeNode> res = new ArrayList<>();
        if (m > n ) {
            res.add(null);
            return res;
        }
        for (int i = m ; i <= n ; i++){
            List<TreeNode> leftSet = dfs(m , i - 1);
            List<TreeNode> rightSet = dfs(i + 1 , n);
            for (TreeNode right : rightSet){
                for (TreeNode left : leftSet){
                    TreeNode top = new TreeNode(i);
                    top.left = left;
                    top.right = right;
                    res.add(top);
                }
            }
        }
        return res;
    }
}
