package Top100.uniquePaths;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-04 9:12
 */


/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int re=t.uniquePathsWithObstacles(new int[][]{{0,1,0,0,0},{0,1,0,1,0},{0,0,0,0,0},{0,1,0,0,0},{0,0,0,1,0}});
        System.out.println(re);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dfs所有可能性，触碰障碍物返回，边界返回
        //会超时 ，剪枝没机会 动态规划 渗透
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]=-1;//标记终点
        int[][] map=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=obstacleGrid.length-1;i>=0;i--){
            //从最后一层开始渗透，标记可以到达重点的次数
            dfs(obstacleGrid,i,0,map);
        }
        return map[0][0];
    }

    //dp
    private void dfs(int[][] obstacleGrid, int i, int j, int[][] map) {
        if (obstacleGrid[i][j]==-1){
            map[i][j]=1;
        }
        if (j+1<obstacleGrid[0].length) {
            dfs(obstacleGrid, i, j + 1, map);
            if (obstacleGrid[i][j]!=1) {
                map[i][j] += map[i][j + 1]; //加上上一个可能到达的值，向右走
            }
        }
        //记录向下的可能值
        if (obstacleGrid[i][j]!=1 && i<obstacleGrid.length-1){
            map[i][j]+=map[i+1][j];
        }

    }


///常规dfs 时间复杂度太高
//    private void dfs(int[][] obstacleGrid, int i, int j) {
//        if (i==obstacleGrid.length || j==obstacleGrid[0].length || obstacleGrid[i][j]==1) return;
//        if (obstacleGrid[i][j]==-1){
//            res++;
//            return;
//        }
//        dfs(obstacleGrid,i+1,j);
//        dfs(obstacleGrid,i,j+1);
//    }
}
