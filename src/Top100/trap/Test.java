package Top100.trap;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-29 8:43
 */

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.trap(new int[]{4,2,3});
        System.out.println(res);
    }

    public int trap(int[] height) {
        //慢指针找到一个不为零的值 快指针往前找到一个大于等于慢指针的值
        //没有找到慢指针加一
        int low=0;
        int fast=0;
        int rear=0;
        while(low!=fast || fast!=height.length-1){
            while (low < height.length && height[low]==0) low++;
            if (low>=height.length) break;
            fast=low+1;
            while(fast < height.length && height[fast]<height[low])  fast++;
            if (fast>=height.length) { //剩下都是高到低或者等同，可以降低高度
                height[low]=height[low]-1;
                continue;
            }
            rear=rear+(fast-low-1)*height[low];
            for (int i=low+1;i<fast;i++){
                rear=rear-height[i];
            }
            low=fast;
        }
        return rear;
    }
}
