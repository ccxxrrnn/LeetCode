package Top100.Search;


/**
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.search(new int[]{1,3,5},5);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        //先找到数组的中间值
        //if mid == target 返回
        // if mid>=first 证明前面都是有序的后面无序的
        //如果 first<=target<mid 二分查找 继续分
        //mid<first 说明后面有序
        //如果 mid<target<=end
        int res=-1;
        if (nums.length==1)return nums[0]==target?0:-1;
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]>=nums[0]){
                if (nums[0]<=target && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if (nums[nums.length-1]>=target && target>nums[mid]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return res;
    }

}
