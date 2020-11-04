package Top100.rotateRight;

import Util.ListNode;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-04 8:50
 */

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public ListNode rotateRight(ListNode head, int k) {
        //在第n次，链表长度的旋转是会回到原点，去除
        //将未旋转部分看作整体，用双指针，后指针改变为指向第一个，前指针保存下一个节点作为结果
        //并且改变指向null
        if (head==null || head.next==null){ //边界条件
            return head;
        }
        ListNode lowHead=head,fastHead=head;  //快慢指针
        ListNode top=head;
        int temp=0; //记录链表长度
        while (head!=null){
            temp++;
            head=head.next;
        }
        k=k%temp;
        if (k==0){
            return top;
        }
        while(k!=0){
            fastHead=fastHead.next;
            k--;
        }
        while (fastHead.next!=null){
            fastHead=fastHead.next;
            lowHead=lowHead.next;
        }
        ListNode res=lowHead.next;
        lowHead.next=null;
        fastHead.next=top;
        return res;
    }
}
