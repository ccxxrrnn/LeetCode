package Top100.isValidBST;

import Util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-14 11:24
 */

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        //边界值
        TreeNode root = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);
        System.out.println(t.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return false;
        }
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        boolean flagR = true,flagL = true;
        if (root.left != null) {
            if (root.left.val < root.val && root.left.val > minValue) {
                flagR = dfs(root.left, minValue, root.val);
            }else{
                return false;
            }
        }
        if (root.right != null ){
            if (root.right.val > root.val && root.right.val < maxValue){
                flagL = dfs(root.right,root.val,maxValue);
            }else{
                return false;
            }
        }
        return flagL && flagR;
    }
}
