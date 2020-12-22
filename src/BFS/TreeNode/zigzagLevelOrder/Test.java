package BFS.TreeNode.zigzagLevelOrder;

import Util.TreeNode;

import java.util.*;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-22 9:12
 */

//103. 二叉树的锯齿形层序遍历
public class Test {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return res;
        deque.addLast(root);
        boolean flag = true;
        while (!deque.isEmpty()){
            int num = deque.size();
            List<Integer> re = new ArrayList<>();
            for (int i = 0 ; i < num ; i++){
                TreeNode t = deque.remove();
                re.add(t.val);
                if (t.left != null) {
                    deque.add(t.left);
                }
                if (t.right != null) {
                    deque.add(t.right);
                }
            }
            if (!flag){
                Collections.reverse(re);
            }
            res.add(re);
            flag = !flag;
        }
        return res;
    }
}
