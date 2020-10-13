package Test2;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-11 13:01
 **/
class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] matrix=new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(solution.findNumberIn2DArray(matrix,23));
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        1、循环遍历
//        for (int[] ints : matrix) {
//            for (int i:ints) {
//                 if(i == target) return true;
//            }
//        }
//        return false;
//        2、搜索树
        int i=matrix.length-1,j=0;
        while(true){
            try {
                if (target==matrix[i][j]){
                    return true;
                }else if (target>matrix[i][j]){
                    j++;
                }else if (target<matrix[i][j]){
                    i--;
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println(i+"     "+j);
                return false;
            }
        }
    }
}

