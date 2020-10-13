package Test4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-11 20:49
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class PrintReverse {

    public static void main(String[] args) {
        PrintReverse printReverse=new PrintReverse();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(2);
        int[] a=printReverse.reversePrint(listNode);
        for (int n:a){
            System.out.println(n);
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] ints=new int[stack.size()];
        for (int i=0;i<ints.length;i++) {
            ints[i]=stack.pop();
        }
        return  ints;
    }

}
