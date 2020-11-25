package Top100.isScramble;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-25 9:18
 */

/**
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public boolean isScramble(String s1, String s2) {
        //满足基本要求  字符串长度要想等
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int m = s1.length();
        int n = s2.length();
        if (m != n){
            return false;
        }
        //可以看作   i 到 k  和 j 到 k 是否可以转换的的  所以结果为dp[0][0][n]
        boolean[][][] dp = new boolean[n][n][n + 1];
        //初始化 一个字符 是否满足
        for (int i = 0;i < n; i++){
            for (int j = 0; j < n; j++){
                dp[i][j][1] = chars1[i] == chars2[j];
            }
        }
        //长度，初始为2，最大为n
        for (int len = 2 ; len <= n ; len++){
            //s1初始位置
            for (int i = 0 ; i <= n - len ; i++){
                //s2初始位置
                for (int j = 0 ; j <= n - len ; j++){
                    //进行分割判断
                    for (int k = 1 ; k <= len - 1 ; k++){
                        //第一种情况  就是没有交换
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                        //第二种进行了交换
                        if (dp[i + len - k][j + len - k][k] && dp[i + k][j][len - k]){
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
