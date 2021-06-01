package DP.String.numDistinct;

/**
 * @Author xiongwei
 * @WriteTime 2021-03-17 16:44
 */

//115. 不同的子序列
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        for(int i = 0 ; i <= lenS ; i++){
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <= lenS ; i++){
            for(int j = 1 ; j <= lenT ; j++){
                if(j > i){
                    continue;
                }
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }
}
