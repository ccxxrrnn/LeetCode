package DP.Int.fib;

/**
 * @Author xiongwei
 * @WriteTime 2021-01-04 10:13
 */


//509. 斐波那契数
public class Test {

    public int fib(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) return a;
        if (n == 1) return b;
        for (int i = 2 ; i <= n ; i++){
            int j = b;
            b = a + b;
            a = j;
        }
        return b;
    }

//    public int fib(int n) {
//        int[] dp = new int[n + 1];
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2 ; i <= n ; i++){
//            dp[i] = dp[i - 2] + dp[i - 1];
//        }
//        return dp[n];
//    }

}
