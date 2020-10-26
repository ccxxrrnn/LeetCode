package Top100.NextPermutation;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-26 14:39
 **/

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 *
 * 时间复杂度：O(n)，在最坏的情况下，只需要对整个数组进行两次扫描。
 *
 * 空间复杂度：O(1)，没有使用额外的空间，原地替换足以做到。
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.nextPermutation(new int[]{5,8,3,4,9,6,4});
    }

    public void nextPermutation(int[] nums) {
        // 下一个排序，则从最后位开始往前搜索，每搜索一个，往后找有没有比他大的值，选取最接近的，有就交换退出，剩下的从小到大排列
        int m=0;//结束，即从m+1开始从小到大排序
        int instance=Integer.MAX_VALUE;
        int tip=0; //标记交换的位置
        for(int i=nums.length-2;i>=0;i--){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]<nums[j]  && nums[j]-nums[i]<instance && nums[j]-nums[i]>0){
                    instance=nums[j]-nums[i];
                    tip=j;
                }
            }
            if (instance!=Integer.MAX_VALUE){
                swap(nums, i,tip);
                m=i+1;
                break;
            }
        }
        for(int i=m;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t=nums[b];
        nums[b]=nums[a];
        nums[a]=t;
    }

}
