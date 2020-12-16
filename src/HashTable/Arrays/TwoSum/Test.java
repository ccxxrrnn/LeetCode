package HashTable.Arrays.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 8:58
 **/

//1. 两数之和

//哈希表
//暴力法
public class Test {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        for(int i = 0 ; i < nums.length ; i++){
//            for(int j = i + 1 ; j < nums.length ; j++){
//                if(nums[i] + nums[j] == target){
//                    res[0] = i;
//                    res[1] = j;
//                }
//            }
//        }
//        return res;
//    }
}
