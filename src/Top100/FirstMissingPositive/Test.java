package Top100.FirstMissingPositive;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-28 10:46
 */

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        //假设nums[i]为结果的前一位  可知最大值也就为nums.length+1
        int n=nums.length;
        for(int i=0;i<n;i++){
            if (nums[i]<=0){ //忽略的非正整数
                nums[i]=n+1;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<n;i++) {
            int num=Math.abs(nums[i]);
            if (num <= n) {  //假如答案为1 ，找到长度小于等于n的值 让他们把值占住， 下标加一为结果
                nums[num - 1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i=0;i<n;i++){
            if (nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
