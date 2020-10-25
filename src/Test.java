import Util.ListNode;

import java.util.*;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-13 10:14
 **/
public class Test {
    public static void main(String[] args) {
        TestMethod testMethod = new TestMethod();

        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(list.toString());
//        Queue<String> queue=new ArrayDeque<>();
//        List<Integer> list=new ArrayList<>();
//        List<Integer> list1=new ArrayList<>();
//        List<Integer> list2=new ArrayList<>();
//        list1.add(1);
//        list1.add(3);
//        list2.add(5);
//        list.addAll(list1);
//        list.addAll(list2);
//        System.out.println(list.toString());
//        ObjectOutputStream objectOutputStream=new ObjectOutputStream(s);
//        String regex="\\s+[+-]?\\w+";
//        Pattern pattern=Pattern.compile(regex);
//        Matcher matcher=pattern.matcher(s);
//        System.out.println(matcher.regionStart());
//        int[][] ints=new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
//        int i=3;
//        testMethod.LRU(ints,i);
//        List<Integer> list=new ArrayList<>();
//        int[] arr1 = list.stream().mapToInt(Integer::intValue).toArray();
//        Test test = new Test();
//        ListNode listNode1=new ListNode(9);
//        listNode1.next=new ListNode(3);
//        listNode1.next.next=new ListNode(7);
//        ListNode listNode2=new ListNode(6);
//        listNode2.next=new ListNode(3);
//        ListNode listNode=test.addInList(listNode1,listNode2);
//        System.out.println(listNode.val);
//        String s="5525";
        //        testMethod.callableTest1();  //创建线程用 callable + FutureTask
    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        Stack<Integer> resStack=new Stack<>();
        if(head1==null) return head2;
        if(head2==null) return head1;
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
