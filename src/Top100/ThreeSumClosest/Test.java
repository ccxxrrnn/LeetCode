package Top100.ThreeSumClosest;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-21 11:25
 **/

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *

 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[] nums=new int[]{1,2,4,8,16,32,64,128};
        int out=t.threeSumClosest(nums, 82);
        System.out.println(out);
    }

    public int threeSumClosest(int[] nums, int target) {
        int close=Integer.MAX_VALUE;  //三数和距离最小值
        Arrays.sort(nums);
        int result=0;   //结果
        for (int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                int temp=sum-target;  //
                if (Math.abs(temp) <= close) {
                    close = Math.abs(temp);
                    System.out.println(close);
                    result=sum;
                }
                if (temp==0) return result;
                if (temp>0) right--;
                if (temp<0) left++;
            }
        }
        return result;
    }
}
