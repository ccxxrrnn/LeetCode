package DoublePoint.ListNode.RemoveNthFromEnd;

import Util.ListNode;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 14:21
 **/

//19. 删除链表的倒数第N个节点
public class Test {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode next = head;
        ListNode pre = head;
        while (n != 0 ){
            next = next.next;
            n--;
        }
        if (next == null) return pre.next;
        while (next.next != null){
            next = next.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return res.next;
    }

}
