package TestDeleteNode;

import Util.ListNode;

import java.util.ArrayList;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-13 15:43
 **/
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(4);
        listNode = Test.class.newInstance().deleteNode(listNode,3);
        System.out.println(listNode.val);
    }

    public ListNode deleteNode(ListNode head, int val) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(head!=null){
            if(head.val!=val) {
                arrayList.add(head.val);
            }
            head = head.next;
        }
        ListNode listNode=new ListNode(arrayList.get(0));
        ListNode copy=listNode;
        for(int j=1;j<arrayList.size();j++){
            listNode.next=new ListNode(arrayList.get(j));
            listNode=listNode.next;
        }
        return copy;
    }
}
