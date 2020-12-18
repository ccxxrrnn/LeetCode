package DoublePoint.Arrays.ThreeSum;

import java.util.*;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-21 9:56
 **/

//15. 三数之和
public class Test {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0 ; i < nums.length-2 ; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length-1;
            while(left < right){
                int x = nums[i];
                int y = nums[left];
                int z = nums[right];
                if (x + y + z == 0){
                    List<Integer> result=new ArrayList<>(Arrays.asList(x,y,z));
                    results.add(result);
                    left++;
                    right--;
                    while (left < right && nums[left] == y) left++;
                    while (left < right && nums[right] == z) right--;
                }
                if (x + y + z < 0){
                    left++;
                }
                if (x + y + z > 0){
                    right--;
                }
            }
        }
        return results;
    }

}
