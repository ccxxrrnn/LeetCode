package DP.Arrays.minCostClimbingStairs;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-21 10:31
 */

//746. 使用最小花费爬楼梯
public class Test {

//    public int minCostClimbingStairs(int[] cost) {
//        int lenC = cost.length;
//        int[][] dp = new int[lenC + 1][2];
//        dp[0][0] = cost[0];
//        dp[0][1] = Integer.MAX_VALUE;  //这是不可能的
//        dp[1][0] = cost[0] + cost[1];
//        dp[1][1] = cost[1];
//        for (int i = 2 ; i < lenC + 1 ; i++){
//            int add;
//            if (i == lenC){
//                add = 0;
//            }else{
//                add = cost[i];
//            }
//            dp[i][0] = Math.min(dp[i - 1][0],dp[i - 1][1]) + add;
//            dp[i][1] = Math.min(dp[i - 2][0],dp[i - 2][1]) + add;
//        }
//        return Math.min(dp[lenC][0],dp[lenC][1]);
//    }

    public int minCostClimbingStairs(int[] cost) {
        int lenC = cost.length;
        int[] dp = new int[lenC + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2 ; i < lenC + 1 ; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[lenC];
    }
}
