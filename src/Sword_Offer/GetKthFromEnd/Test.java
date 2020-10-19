package Sword_Offer.GetKthFromEnd;

import Util.ListNode;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-14 16:41
 **/
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(4);
        listNode=t.getKthFromEnd(listNode,2); //2->4
        System.out.println(listNode.val);
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode copy=head;
        while(true) {
            if (k != 0) {
                k--;
                copy=copy.next;
                continue;
            }
            if (copy==null){
                return head;
            }
            head=head.next;
            copy=copy.next;
        }
    }
}
