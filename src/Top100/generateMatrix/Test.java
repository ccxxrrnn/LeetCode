package Top100.generateMatrix;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-03 14:20
 */

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[][] res = t.generateMatrix(5);
        for (int[] re :res){
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] generateMatrix(int n) {
        //模拟涂写过程
        int[][] res=new int[n][n]; //结果
        int maxNum=n*n;    //最大数
        //结束条件 画完所有图
        int temp=0;  //记录画的次数
        int i=0;  //横坐标
        int j=0;  //纵坐标
        while (temp!=maxNum){
            System.out.println(Arrays.deepToString(res));
            //画起始
            temp++;
            res[i][j]=temp;
            //往右画
            while(j+1<n && res[i][j+1]==0){
                temp++;
                j++;
                res[i][j]=temp;
            }
            while (i+1<n && res[i+1][j]==0){
                temp++;
                i++;
                res[i][j]=temp;
            }
            while(j-1>=0 && res[i][j-1]==0){
                temp++;
                j--;
                res[i][j]=temp;
            }
            while(i-1>=0 && res[i-1][j]==0){
                temp++;
                i--;
                res[i][j]=temp;
            }
            //最后左移找到下一个范围的起始
            j++;
        }
        return res;
    }
}
