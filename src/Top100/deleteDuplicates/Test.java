package Top100.deleteDuplicates;

import Util.ChangeUtil;
import Util.ListNode;

import java.util.*;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-17 10:26
 */

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        ListNode listNode = t.deleteDuplicates(ChangeUtil.arrChangeNode(new int[]{1,2,3,3,4,5,6,8,8,8,8,8,8}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        Deque<ListNode> deque =new  ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while (head != null){
            if (list.contains(head.val)){
                head = head.next;
                continue;
            }
            if (deque.size() == 0 || head.val != deque.peekLast().val){
                deque.add(head);
            }else{
                list.add(deque.removeLast().val);
            }
            head = head.next;
        }
        if (deque.size() == 0) return null;
        ListNode pre = new ListNode(deque.removeFirst().val);
        ListNode nextNode = pre;
        while (!deque.isEmpty()){
            nextNode.next = deque.removeFirst();
            nextNode = nextNode.next;
        }
        //清除后面的数据
        nextNode.next = null;
        return pre;
    }
}
