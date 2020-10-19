package Top100.TwoSum;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 8:58
 **/
public class Test {

    public static void main(String[] args) {
        Test test =new Test();
        int[] input=new int[]{2,7,11,9};
        int[] out= test.twoSum(input,9);
        System.out.println(Arrays.toString(out));
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] result=new int[2];
//        int fast=0;
//        return result;
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
}
