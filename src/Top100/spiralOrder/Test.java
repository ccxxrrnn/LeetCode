package Top100.spiralOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-01 19:28
 */

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        int[][] input={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] input={};
        List<Integer> res = t.spiralOrder(input);
        System.out.println(res.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        //先向右，下，左，上进行  ，每移动到一位就修改值为-min
        //触碰调转方向  //到达边界值 或者值为-min
        //旋转终止条件 list长度等于矩阵h*l
        List<Integer> res=new ArrayList<>();
        if (matrix == null || matrix.length==0) return res;
        int h=matrix.length;
        int l=matrix[0].length;
        int i=0,j=0;
        while(res.size()!=h*l){
            res.add(matrix[i][j]);
            matrix[i][j]=Integer.MIN_VALUE;
//            System.out.println(res.toString());
//            System.out.println(i+"           "+ j);
            while(j+1<l && matrix[i][j+1]!=Integer.MIN_VALUE){
                j++;
                res.add(matrix[i][j]);
//                if (j==l-1) break;
                matrix[i][j]=Integer.MIN_VALUE;
            }
            while(i+1<h && matrix[i + 1][j] != Integer.MIN_VALUE){
                i++;
                res.add(matrix[i][j]);
//                if (i==h-1) break;
                matrix[i][j]=Integer.MIN_VALUE;
            }
            while ( j - 1>=0 && matrix[i][j-1] != Integer.MIN_VALUE){
                j--;
                res.add(matrix[i][j]);
//                if (j==0) break;;
                matrix[i][j]=Integer.MIN_VALUE;
            }
            System.out.println(Arrays.deepToString(matrix));
            while(i - 1>=0 && matrix[i-1][j] != Integer.MIN_VALUE){
                i--;
                res.add(matrix[i][j]);
                matrix[i][j]=Integer.MIN_VALUE;
//                if (i==1) break;
            }
            j++;
        }
        return res;
    }
}
