package Simulation.LinkedList.AddTwoNumbers;

import Util.ListNode;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 9:27
 **/


//2. 两数相加
//数学模拟
public class Test {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode next = res;
        int target = 0;  //判断是否进位
        while (l1 != null || l2 != null){
            int value1 = 0,value2 = 0;
            if (l1 != null) value1 = l1.val;
            if (l2 != null) value2 = l2.val;
            int add = value1 + value2 + target;
            if (add >= 10){
                target = 1;
                add -= 10;
            }else{
                target = 0;
            }
            next.next = new ListNode(add);
            next = next.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (target == 1) next.next = new ListNode(1);
        return res.next;
    }

}
