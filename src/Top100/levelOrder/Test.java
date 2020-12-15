package Top100.levelOrder;

import Util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-15 11:00
 */

//102. 二叉树的层序遍历
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null){
            deque.push(root);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!deque.isEmpty()){
            int index = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0 ; i < index ; i++){
                TreeNode treeNode = deque.removeFirst();
                list.add(treeNode.val);
                if (treeNode.left != null){
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.addLast(treeNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
