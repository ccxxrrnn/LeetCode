package Greedy.Arrays.minPatches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-29 10:26
 */

//330. 按要求补齐数组
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        System.out.println(t.minPatches(new int[]{1,2,11,33}, 2147483647));
    }

    public int minPatches(int[] nums, int n) {
        int count = 0;
        int indexN = 0,num = 0,lenN = nums.length;
        while (num < n){
            if (indexN >= lenN || num + 1 < nums[indexN]) {
                count++;
                num += num + 1;
            } else {
                num += nums[indexN];
                indexN++;
            }
        }
        return count;
    }

//    public int minPatches(int[] nums, int n) {
//        if (n >= Integer.MAX_VALUE) n = Integer.MAX_VALUE - 2;
//        int[] numArr = new int[n + 1];
//        numArr[0] = 1;
//        for (int num : nums) {
//            add(num, numArr);
//        }
//        int res = 0;
//        for (int i = 1 ; i <= n ; i++){
//            if (numArr[i] == 0){
//                res += 1;
//                add(i,numArr);
//            }
//        }
//        return res;
//    }
//
//
//    private void add(int i, int[] numArr) {
//        List<Integer> list = new ArrayList<>();
//        for (int j = 0 ; j < numArr.length ; j++){
//            if (numArr[j] == 1) {
//                list.add(j);
//            }
//        }
//        for (int j : list){
//            if (j + i < numArr.length) {
//                numArr[j + i] = 1;
//            }else{
//                break;
//            }
//        }
//    }
}
