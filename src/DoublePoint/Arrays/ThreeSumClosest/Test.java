package DoublePoint.Arrays.ThreeSumClosest;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-21 11:25
 **/

//16. 最接近的三数之和
public class Test {

    public int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;  //三数和距离最小值
        Arrays.sort(nums);
        int result = 0;   //结果
        for (int i = 0;i < nums.length-2 ; i++){
            int left = i + 1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int temp = sum-target;  //
                if (Math.abs(temp) <= close) {
                    close = Math.abs(temp);
//                    System.out.println(close);
                    result = sum;
                }
                if (temp == 0) return result;
                if (temp > 0) right--;
                if (temp < 0) left++;
            }
        }
        return result;
    }
}
