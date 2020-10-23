package Top100.ReverseKGroup;

import Util.ListNode;

import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 17:10
 **/

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null ) {
            return head;
        }
        ListNode result=head;
        Stack<ListNode> stack=new Stack<>();
        for (int i=0;i<k;i++){
            if (head==null) return result;
            stack.push(head);
            head=head.next;
        }
        result=stack.pop();
        ListNode next=result;
        while(!stack.isEmpty()){
            next.next=stack.pop();
            next=next.next;
        }
        next.next=reverseKGroup(head, k);
        return result;
    }
}
