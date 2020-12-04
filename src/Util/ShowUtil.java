package Util;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-03 11:23
 */

public class ShowUtil {

    public  static void showListNode(ListNode listNode){
        if (listNode == null) System.out.println("null");
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
