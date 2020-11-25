package Top100.partition;

import Util.ChangeUtil;
import Util.ListNode;
import Util.PrintUtil;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-20 9:15
 */

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        PrintUtil.printListNode(t.partition(ChangeUtil.arrChangeNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
        PrintUtil.printListNode(t.partition(ChangeUtil.arrChangeNode(new int[]{3,1,2}), 3));
        PrintUtil.printListNode(t.partition(ChangeUtil.arrChangeNode(new int[]{}), 3));
        PrintUtil.printListNode(t.partition(ChangeUtil.arrChangeNode(new int[]{1}), 0));
    }

    public ListNode partition(ListNode head, int x) {
        //首先需要先找到大于x值的node
        //需要改造ListNode
        ListNode myHead = new ListNode(x - 1);
        ListNode res = myHead;
        myHead.next = head;
        ListNode pre = null;
        if (head == null) return head;
        while (myHead != null){
            if (myHead.next == null) break;//最后一位大于不用计算
            if (myHead.next.val >= x && pre == null){
                pre = myHead;
            }
            while (myHead.next != null && pre != null && myHead.next.val < x){
                ListNode hidden = pre.next; //保存首后部
                ListNode nextNode = myHead.next.next;
                pre.next = myHead.next;
                pre.next.next = hidden;
                myHead.next = nextNode; // 删除位置,替换
                pre = pre.next;
            }
            myHead = myHead.next;
        }
        return res.next;
    }
}
