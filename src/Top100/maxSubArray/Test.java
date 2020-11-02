package Top100.maxSubArray;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-30 19:06
 */

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int maxSubArray(int[] nums) {
        //
        int res=nums[0];
        int sum=0;
        for (int n:nums){
            if (sum>0){
                sum+=n;
            }else{
                sum=n;
            }
            res=Math.max(sum,res);
        }
        return res;
    }
}
