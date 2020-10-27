package Top100.SearchRange;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-27 10:35
 */

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int[] searchRange(int[] nums, int target) {
        //用二分查找搜索nums中target的位置，然后向前，向后试探
        int l=0,r=nums.length-1;
        int tarindex=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if (target==nums[mid]) tarindex=mid;
            if (target>nums[mid]){
                l=mid+1;
            } else{
              r=mid-1;
            }
        }
        int start=tarindex; int end=tarindex;
        while(tarindex!=-1 && start>0 && nums[start-1]==nums[start]) start--;
        while(tarindex!=-1 && end<nums.length-1 && nums[end+1]==nums[end]) end++;
        return new int[]{start,end};
    }
}
