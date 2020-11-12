package Top100.searchMatrix;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-12 9:19
 */

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * 输出：false
 * 示例 3：
 *
 * 输入：matrix = [], target = 0
 * 输出：false
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        System.out.println(t.searchMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //由于第二个首位大于第一行最后一位，可以先搜索行，找出位于哪一行再搜索
        //为空
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        //小于最小 大于最大
        if (matrix[0][0] == target || matrix[matrix.length - 1][matrix[0].length - 1] == target) return true;
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) return false;
        //找出所在行,如果执行完 就证明可能在最后一行
        int searchRow=matrix.length - 1;
        for (int i = 0;i < matrix.length - 1 ; i++){
            if (matrix[i][0] == target) return true;
            if (matrix[i][0] < target && matrix[i+1][0] > target){
                searchRow = i;
                break;
            }
        }
        for (int i = 0;i < matrix[0].length; i++){
            if (matrix[searchRow][i] == target) return true;
            if (i != matrix[0].length - 1 && matrix[searchRow][i] > target && matrix[searchRow][i + 1] < target){
                return false;
            }
        }
        return false;
    }
}
