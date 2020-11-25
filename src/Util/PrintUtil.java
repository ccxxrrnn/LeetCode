package Util;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-20 9:48
 */

public class PrintUtil {

    public static void printListNode(ListNode listNode){
        if (listNode == null) {
            System.out.println("");
            return;
        }
        while (listNode.next != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
}
