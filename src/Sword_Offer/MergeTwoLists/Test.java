package Sword_Offer.MergeTwoLists;

import Util.ListNode;

import java.util.*;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-14 19:03
 **/
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(4);
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(3);
        listNode1.next.next=new ListNode(4);
        ListNode listNode2=t.mergeTwoLists(listNode1,listNode);
        while(listNode2!=null){
            System.out.println(listNode2.val);
            listNode2=listNode2.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> list=new ArrayList<>();
        while(l1!=null){
            list.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            list.add(l2.val);
            l2=l2.next;
        }
        Collections.sort(list);
        ListNode listNode=new ListNode(0);
        ListNode head=listNode;
        for (Integer i:list){
            head.next=new ListNode(i);
            head=head.next;
        }
        return listNode.next;
    }
}
