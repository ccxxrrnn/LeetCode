package Top100.largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-18 14:33
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        System.out.println(t.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(t.largestRectangleArea(new int[]{2,1,2}));
//        System.out.println(t.largestRectangleArea(new int[]{1,2,3,4,6}));
    }




    //单调栈
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();  //
        int[] hs= new int[heights.length + 2];
        System.arraycopy(heights, 0, hs, 1, heights.length);

        int area = 0;
        for (int i = 0; i < hs.length  ; i++){
            //一直找直到发现 第i个的高小于 i-1的高
            //否则就说明第 i-1 长度的最大面积可以求出
            int h = hs[i];
            while (!stack.isEmpty() && hs[stack.peek()] > h) {  //一直找到处理完，逐渐递增的栈
                int j = stack.pop();
                int height = hs[j];  //得到高
                area = Math.max(area,height * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return area;
    }

    //暴力法
//    public int largestRectangleArea(int[] heights) {
//        //面积 底 乘 高  固定高 ，遍历底
//        int area = 0;
//        for(int i = 0 ; i < heights.length ; i++){
//            int left = i;  //左
//            int right = i; //右
//            while (left >= 0 && heights[left] >= heights[i]){
//                left--;
//            }
//            while (right < heights.length && heights[right] >= heights[i]){
//                right++;
//            }
//            area = Math.max(area,heights[i] * (right - left - 1));
//        }
//        return area;
//    }
}
