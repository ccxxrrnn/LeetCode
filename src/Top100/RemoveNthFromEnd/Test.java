package Top100.RemoveNthFromEnd;

import Util.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 14:21
 **/

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack=new Stack<>();
        ListNode result=head;
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode deleteLi = null;
        while(n!=0){
            deleteLi=stack.pop();
            n--;
        }
//        if (deleteLi.next!=null) {
        if (!stack.isEmpty()){
            stack.pop().next = deleteLi.next;
        }else{
            return result.next;
        }
//        }else {
//            stack.pop().next=null;
//        }
        return result;
    }
}
