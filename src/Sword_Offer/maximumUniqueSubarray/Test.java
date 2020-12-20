package Sword_Offer.maximumUniqueSubarray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-20 10:57
 */

//gg 读不懂提
public class Test {

    public int maximumUniqueSubarray(int[] nums) {
        Deque<Integer> deque;
        if (nums.length == 1 )return nums[0];
        int right = 1;
        int res = 0;
        int now = 0;
        while (right < nums.length){
            deque = new ArrayDeque<>();
            now += nums[right - 1];
            while (right < nums.length && !deque.contains(nums[right])){
                deque.addLast(nums[right]);
                now += nums[right];
                right++;
            }
            res = Math.max(now,res);
            if(right ==  nums.length) break;
            while (deque.contains(nums[right])){
                Integer integer = deque.removeFirst();
                now -= integer;
            }
        }
        return res;
    }
}
