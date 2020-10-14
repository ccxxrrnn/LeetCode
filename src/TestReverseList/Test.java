package TestReverseList;

import Util.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-14 16:58
 **/
public class Test {
    public static void main(String[] args) {
        Test test=new Test();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(4);
        listNode=test.reverseList(listNode);
        System.out.println(listNode.val);
    }
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return head;
        }
        Stack<Integer> stack=new Stack<>();
        while (head.next!=null){
            stack.push(head.val);
            head=head.next;
        }
        ListNode listNode=head;
        while(!stack.empty()){
            listNode.next=new ListNode(stack.pop());
            listNode=listNode.next;
        }
        return head;
    }
}
