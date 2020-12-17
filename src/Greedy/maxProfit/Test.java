package Greedy.maxProfit;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-17 9:52
 */

//714. 买卖股票的最佳时机含手续费
public class Test {

    public int maxProfit(int[] prices, int fee) {
        int lenP = prices.length;
        int[][] dp =new int[lenP ][2]; //到第i天 0表示抛出股票   1表示持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1 ; i < lenP ; i++){
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1] - fee,dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1] , dp[i - 1][0] - prices[i]);
        }
        return dp[lenP - 1][0];
    }
}
