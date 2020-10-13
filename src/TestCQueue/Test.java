package TestCQueue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-12 9:57
 **/
class CQueue {
    Stack<Integer> stackA=new Stack<>();
    Stack<Integer> stackB=new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead(){
        if (stackA!=null) {
            int size=stackA.size();
            for (int i=0;i<size;i++){
                stackB.push(stackA.pop());
            }
            try {

                int res=stackB.pop();
                for (int j=0;j<size-1;j++) {
                    stackA.push(stackB.pop());
                }
                return res;
            }catch (EmptyStackException e){
                return -1;
            }
        }
        return -1;
    }
}
public class Test {
    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(7);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
