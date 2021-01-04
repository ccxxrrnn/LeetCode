package DoublePoint.ListNode.partition;

import Util.ListNode;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-20 9:15
 */


//86. 分隔链表
public class Test {



    // 2021 - 01 - 03
    public ListNode partition(ListNode head, int x) {
        ListNode end = null , endStart = null , res = new ListNode(-1) ; //这是添加到末尾的
        ListNode resHeadPre = res;
        while (head != null){
            if (head.val < x){
                res.next = head;
                res = res.next;
            }else{
                if (end == null) {
                    end = head;
                    endStart = head;
                }else{
                    end.next = head;
                    end = end.next;
                }
            }
            head = head.next;
        }
        if (end != null) {
            end.next = null;
        }
        res.next = endStart;
        return resHeadPre.next;
    }

    //2020 - 11 - 20
//    public ListNode partition(ListNode head, int x) {
//        //首先需要先找到大于x值的node
//        //需要改造ListNode
//        ListNode myHead = new ListNode(x - 1);
//        ListNode res = myHead;
//        myHead.next = head;
//        ListNode pre = null;
//        if (head == null) return head;
//        while (myHead != null){
//            if (myHead.next == null) break;//最后一位大于不用计算
//            if (myHead.next.val >= x && pre == null){
//                pre = myHead;
//            }
//            while (myHead.next != null && pre != null && myHead.next.val < x){
//                ListNode hidden = pre.next; //保存首后部
//                ListNode nextNode = myHead.next.next;
//                pre.next = myHead.next;
//                pre.next.next = hidden;
//                myHead.next = nextNode; // 删除位置,替换
//                pre = pre.next;
//            }
//            myHead = myHead.next;
//        }
//        return res.next;
//    }

}
