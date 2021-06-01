package Top100.reverseBetween;

import Util.ChangeUtil;
import Util.ListNode;
import Util.ShowUtil;

import java.util.List;
import java.util.Stack;


//92. 反转链表 II
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        ShowUtil.showListNode(t.reverseBetween(ChangeUtil.arrChangeNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }

    //2021-03-18 新思路
    //思路简单粗暴，类似于冒泡？
    // 例如， 例题， 1 2 3 4 5 ，
    // 先交换2 3 ，
    // 修改为 1 3 2 4 5 ，
    // 这个时候将3 2 看作整体 ，
    // 1 [start,end] 4 5，
    // 不用说也知道交换整体和4，
    // 1 4 [start,end] 5，
    // 4再加入整体改变start，很简单的思路，
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        for(int i = 0 ; i < left - 1 ; i++){
            pre = pre.next;//开始点
        }
        ListNode start = pre.next;
        ListNode end = pre.next;
        for(int i = 0; i < right - left ; i++){
            pre.next = end.next;
            end.next = end.next.next;
            pre.next.next = start;
            start = pre.next;
        }
        return res.next;
    }

    /**
     * 栈处理
     * @param head
     * @param m
     * @param n
     * @return
     */
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        Stack<ListNode> stack = new Stack<>();
//        int index = 1;
//        ListNode res = new ListNode(0);
//        res.next = head;
//        ListNode pre = res;  //这是反转开始的前一个结点
//        while (head != null){
//            if (index + 1 == m) pre = head;
//            if (index >= m && index <= n){
//                stack.push(head);
//            }
//            if (index == n){
//                //开始反转
//                head = head.next;
//                while (!stack.isEmpty()){
//                    pre.next = stack.pop();
//                    pre = pre.next;
//                }
//                pre.next = head;
//                return res.next;
//            }
//            index++;
//            head = head.next;
//        }
//        return res.next;
//    }
}
