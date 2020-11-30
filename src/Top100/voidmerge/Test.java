package Top100.voidmerge;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-27 10:01
 */

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.merge(new int[]{0},0,new int[]{1},1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //二个指针，因为二个数组都是有序的 //从后往前找，大的放后面
        while (m + n > 0){
            if (n == 0 || (m >0 && nums1[m - 1] > nums2[n - 1] )){
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
