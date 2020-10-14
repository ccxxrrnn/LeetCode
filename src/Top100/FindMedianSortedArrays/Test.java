package Top100.FindMedianSortedArrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 18:55
 **/

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[] input1=new int[]{};
        int[] input2=new int[]{2,4,5,6};
        Double out=t.findMedianSortedArrays(input1,input2);
        System.out.println(out);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1=0;
        int end1=nums1.length-1;
        int start2=0;
        int end2=nums2.length-1;
        while(start1<=end1 && start2<=end2){
            if (start1==end1 && start2==end2){
                double i=nums1[start1];
                double j=nums2[start2];
                return (i+j)/2;
            }
            if (nums1[start1]>nums2[start2]){
                start2++;
            }else{
                start1++;
            }
            if (nums1[end1]>nums2[end2]){
                end1--;
            }else{
                end2--;
            }
        }
        while(start1<=end1){
            if (start1==end1) return nums1[start1];
            if (++start1 - --end1==1){
                double i=nums1[start1];
                double j=nums1[end1];
                return (i+j)/2;
            }
        }
        while(start2<=end2){
            if (start2==end2) return nums2[start2];
            if (++start2 - --end2==1){
                double i=nums2[start2];
                double j=nums2[end2];
                return (i+j)/2;
            }
        }
        return 0;
    }

}
