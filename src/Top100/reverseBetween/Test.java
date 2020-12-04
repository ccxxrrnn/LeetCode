package Top100.reverseBetween;

import Util.ChangeUtil;
import Util.ListNode;
import Util.ShowUtil;

import java.util.List;
import java.util.Stack;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-03 11:04
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        ShowUtil.showListNode(t.reverseBetween(ChangeUtil.arrChangeNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> stack = new Stack<>();
        int index = 1;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;  //这是反转开始的前一个结点
        while (head != null){
            if (index + 1 == m) pre = head;
            if (index >= m && index <= n){
                stack.push(head);
            }
            if (index == n){
                //开始反转
                head = head.next;
                while (!stack.isEmpty()){
                    pre.next = stack.pop();
                    pre = pre.next;
                }
                pre.next = head;
                return res.next;
            }
            index++;
            head = head.next;
        }
        return res.next;
    }
}
