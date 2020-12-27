package Top100.maximalRectangle;

import java.awt.*;
import java.util.Stack;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-19 8:59
 */

//85. 最大矩形
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    //找到数组交给上一题
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int clo = matrix[0].length;
        int[] heights = new int[clo];
        int area = 0 ;
        for (int i = 0 ; i < row;i++) {
            for (int j = 0; j < clo; j++) {
                heights[j] = matrix[i][j] == '1'?heights[j] + 1:0;
            }
            area = Math.max(area,largestRectangleArea(heights));
        }
        return area;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
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

//    //dp
//    //先找到底再找到高
//    public int maximalRectangle(char[][] matrix) {
//        int row = matrix.length;
//        if (row == 0) return 0;
//        int clo = matrix[0].length;
//        int[][] dp = new int[row][clo];
//        //先找到长度
//        for (int i = 0 ; i < row;i++){
//            for (int j = 0; j < clo ; j++){
//                //如果等于 1 那么底就会加一 ，一直延伸
//                if (matrix[i][j] == '1'){
//                    //假如为第一个
//                    dp[i][j] = j == 0?1:dp[i][j - 1] + 1;
//                }
//            }
//        }
//        int area = 0;
//        //找到高，并求出面积
//        for (int i = 0 ; i < row ; i++){
//            for (int j = 0 ; j < clo ; j++){
//                if (matrix[i][j] == '0') continue;
//                int len = dp[i][j];
//                for (int k = i;k >= 0 && matrix[k][j] == '1';k--){
//                    len = Math.min(len,dp[k][j]);
//                    area = Math.max(area,len * (i - k + 1));
//                }
//            }
//        }
//        return area;
//    }

//    //暴力法
//    public int maximalRectangle(char[][] matrix) {
//        //找到一个点向下延申找到高，然后尝试左右扩散，直到达到最大
//        int area = 0;
//        for (int i = 0 ; i < matrix.length ; i++){
//            for (int j = 0; j <matrix.length ; j++){
//                if (matrix[i][j] == '1'){ //找到点
//                    //向下扩散
//                    int h = 1;  //高
//                    //只需要拿到首位的i ，首i拿到   尾i
//                    int lastI = i;
//                    while (lastI + 1< matrix.length && matrix[lastI + 1][j] == '1'){
//                        lastI++;
//                        h++;
//                    }
//                    //现在拿到高，需要找到底  //遍历i到lasti 想左右延伸
//                    int left = j,right = j;
//                    boolean flag = true;
//                    while (flag) {
//                        for (int k = i; k <= lastI; k++) {
//                            if (matrix[k][left] == '0' || matrix[k][right] == '0'){
//                                flag = false;
//                                break;
//                            }
//                        }
//                        //遍历完，没有碰到，就需要延伸left right,假如已经到延伸的边界就不延伸
//                        left = left >0?left - 1:left;
//                        right = right + 1 < matrix[0].length?right + 1:right;
//                    }
//                    area = Math.max(area,h * (right - left + 1));
//                }
//            }
//        }
//        return area;
//    }
}
