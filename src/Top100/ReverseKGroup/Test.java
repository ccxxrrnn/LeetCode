package Top100.ReverseKGroup;

import Util.ListNode;

import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 17:10
 **/


public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode result = head;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            if (head == null) return result;
            stack.push(head);
            head = head.next;
        }
        result = stack.pop();
        ListNode next = result;
        while (!stack.isEmpty()) {
            next.next = stack.pop();
            next = next.next;
        }
        next.next = reverseKGroup(head, k);
        return result;
    }
}
