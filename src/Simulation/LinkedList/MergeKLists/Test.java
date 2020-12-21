package Simulation.LinkedList.MergeKLists;

import Util.ListNode;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-23 16:09
 **/

//23. 合并K个升序链表
public class Test {


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        int flag = 0;
        while(flag != lists.length){
            int minVal = Integer.MAX_VALUE;
            int tip = 0;
            flag = 0;
            for (int i = 0 ; i < lists.length ; i++){
                if (lists[i] == null){
                    flag++;
                    continue;
                }
                if(lists[i].val < minVal){
                    tip = i;
                    minVal = lists[i].val;
                }
            }
            if (flag != lists.length) {
                head.next = lists[tip];
                lists[tip] = lists[tip].next;
                head = head.next;
            }
        }
        return result.next;
    }
}
