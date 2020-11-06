package Top100.minPathSum;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-06 8:49
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        System.out.println(t.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(t.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
//        System.out.println(t.minPathSum(new int[][]{{1}}));
    }

    private  int res=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        dfs(grid,0,0,grid[0][0]);
        return res;
    }

    //回溯 剪枝
    private void dfs(int[][] grid, int i, int j,int num) {
        if (num<=res && i==grid.length-1 && j==grid[0].length-1){ //到达终点
            res=num;
            return;
        }
        if (i+1>grid.length || j+1<grid[0].length) { //只能向右
            dfs(grid, i, j+1, num+grid[i][j+1]);
        }
        if (j+1>grid[0].length || i+1<grid.length) { //只能向下
             dfs(grid, i+1, j, num+grid[i+1][j]);
         }
    }

    //动态规划
//    public int minPathSum(int[][] grid) {
//        //动态规划
//        int[][] map=new int[grid.length][grid[0].length];
//        map[0][0] = grid[0][0];//初始
//        dp(grid,0,0,map);
//        return map[map.length-1][map[0].length-1];
//    }

//    private void dp(int[][] grid, int i, int j, int[][] map) {
//        if (i==grid.length-1 && j==grid[0].length-1){ //到达终点
//            return;
//        }
//        if (i+1>grid.length || j+1<grid[0].length){ //只能向右
//            if (map[i][j+1]==0) {
//                map[i][j + 1] = grid[i][j + 1] + map[i][j];
//            }else{
//                map[i][j+1]=Math.min(map[i][j+1],grid[i][j + 1] + map[i][j]);
//            }
//            dp(grid, i, j+1, map);
//        }
//        if (j+1>grid[0].length || i+1<grid.length){ //只能向下
//            if (map[i+1][j]==0) {
//                map[i + 1][j] = grid[i + 1][j] + map[i][j];
//            }else{
//                map[i + 1][j]=Math.min(map[i + 1][j],grid[i + 1][j] + map[i][j]);
//            }
//            dp(grid, i+1, j, map);
//        }
//    }
}
