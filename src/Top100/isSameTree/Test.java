package Top100.isSameTree;

import Util.TreeNode;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-15 10:36
 */

//100. 相同的树
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
