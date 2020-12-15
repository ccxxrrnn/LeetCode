package Top100.isSymmetric;

import Util.TreeNode;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-15 10:49
 */

//101. 对称二叉树
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.left,root.right);
    }

    private boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && judge(left.left,right.right) && judge(left.right,right.left);
    }
}
