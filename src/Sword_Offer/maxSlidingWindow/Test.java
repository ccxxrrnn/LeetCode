package Sword_Offer.maxSlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2021-01-02 11:45
 */

//239. 滑动窗口最大值
public class Test {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int lenN = nums.length;
        if (lenN == 0) return new int[0];
        int[] resArr = new int[lenN - k + 1];
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0 ; i < lenN ; i++){
            //保持单调栈
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                list.pollLast();
            }
            list.addLast(i);
            //判断目前单调栈是否合法
            while (!list.isEmpty() && list.peekFirst() < ( i - k + 1)){
                list.pollFirst();
            }
            //满足条件那么首位一定是最大值
            if (!list.isEmpty() && (i - k + 1) >= 0){
                resArr[i - k + 1] = nums[list.peekFirst()];
            }
            System.out.println(Arrays.toString(list.toArray()));
        }
        return resArr;
    }

    //超时
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int lenN = nums.length;
//        if (lenN == 0) return new int[0];
//        int[] resArr = new int[lenN - k + 1];
//        for (int i = 0 ; i < resArr.length ; i++){
//            int num = nums[i];
//            for (int j = 1 ; j < k ; j++){
//                if (num < nums[i + j]){
//                    num = nums[i + j];
//                }
//            }
//            resArr[i] = num;
//        }
//        return resArr;
//    }
}
