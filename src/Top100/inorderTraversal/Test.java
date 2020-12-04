package Top100.inorderTraversal;

import Util.TreeNode;

import java.util.*;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-04 12:41
 */

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        //左根右
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty() ){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
