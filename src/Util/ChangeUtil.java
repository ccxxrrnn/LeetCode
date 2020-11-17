package Util;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-17 10:43
 */

public class ChangeUtil {

    public static ListNode arrChangeNode(int[] nums){
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        for (int i = 1 ; i < nums.length ; i++){
            pre.next = new ListNode(nums[i]);
            pre = pre.next;
        }
        return head;
    }
}
