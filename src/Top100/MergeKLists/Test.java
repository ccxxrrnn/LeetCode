package Top100.MergeKLists;

import Util.ListNode;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 16:09
 **/

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        ListNode listNode=null;
        ListNode listNode1=new ListNode(1);
        ListNode[] listNodes=new ListNode[]{null,listNode1};
        System.out.println(t.mergeKLists(listNodes).val);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(-1);
        ListNode head=result;
        int flag=0;
        while(flag!=lists.length){
            int minVal=Integer.MAX_VALUE;
            int tip=0;
            flag=0;
            for (int i=0;i<lists.length;i++){
                if (lists[i]==null){
                    flag++;
                    continue;
                }
                if(lists[i].val<minVal){
                    tip=i;
                    minVal=lists[i].val;
                }
            }
            if (flag!=lists.length) {
                head.next = lists[tip];
                lists[tip] = lists[tip].next;
                head = head.next;
            }
        }
        return result.next;
    }
}
