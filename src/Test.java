import Util.ListNode;

import java.util.*;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-13 10:14
 **/
public class Test {
    public static void main(String[] args) {
        TestMethod testMethod = new TestMethod();
        int[] arr = new int[]{6,5,9,7,8,2,3,1,6,4,6,5};
//        System.out.println((3 & 1) == 1);
//        AllSort.bubbleSort(arr); //冒泡
//        AllSort.selectionSort(arr); //选择
//        AllSort.insertionSort(arr); //插入
//        AllSort.shellSort(arr);
        AllSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        Stack<Integer> resStack=new Stack<>();
        if(head1==null) {
            return head2;
        }
        if(head2==null) {
            return head1;
        }
        while(head1!=null){
            stack1.push(head1.val);
            head1=head1.next;
        }
        while(head2!=null){
            stack2.push(head2.val);
            head2=head2.next;
        }
        resStack.push(0);
        while(stack1.size()!=0 && stack2.size()!=0){
            int num=stack1.pop()+stack2.pop();
            if (num>=10){
                resStack.push(num-10);
            } else{
                resStack.push(num);
            }
        }
        while(stack1.size()!=0){
                resStack.push(stack1.pop());
        }
        while(stack2.size()!=0) {
            resStack.push(stack2.pop());
        }
        System.out.println(resStack.toString());
        return  null;
    }


}
