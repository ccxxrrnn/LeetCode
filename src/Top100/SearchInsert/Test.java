package Top100.SearchInsert;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-27 10:49
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.searchInsert(new int[]{1,5,10,11},4);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        //找到第一个比target大的下标
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if (target>nums[mid]){
                l=mid+1;
            } else{
                r=mid-1;
            }
        }
        return l;
    }
}
