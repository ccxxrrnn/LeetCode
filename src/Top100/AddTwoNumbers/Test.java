package Top100.AddTwoNumbers;

import Util.ListNode;

import java.util.LinkedList;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 9:27
 **/

/**
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        ListNode listNode1=new ListNode(7);
        listNode1.next=new ListNode(3);
        listNode1.next.next=new ListNode(9);
        ListNode listNode2=new ListNode(3);
        listNode2.next=new ListNode(6);
        ListNode out=t.addTwoNumbers(listNode1,listNode2);
        while(out!=null){
            System.out.println(out.val);
            out=out.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> resultList=new LinkedList<>();
        while(l1!=null || l2!=null){
            if(l1==null){
                resultList.add(l2);
                l2=l2.next;
                continue;
            }
            if(l2==null) {
                resultList.add(l1);
                l1 = l1.next;
                continue;
            }
            resultList.add(new ListNode(l1.val+l2.val));
            l1=l1.next;
            l2=l2.next;
        }
        int tip=0;
        ListNode result=new ListNode(-1);
        ListNode head=result;
        for(ListNode l:resultList){
            l.val= l.val+tip;
            if (l.val>=10){
                l.val=l.val-10;
                tip=1;
            }else{
                tip=0;
            }
            head.next=l;
            head=head.next;
        }
        if (tip!=0){
            head.next=new ListNode(1);
        }
        return result.next;
    }
}
