package Top100.minDistance;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-11 14:30
 */

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int minDistance(String word1, String word2) {
        //从末尾比较 word1 的最后一位 分为 3种情况
        //1最后一位 和 2的最后一位相等   计算情况变为 word1(0,num1 - 1) word2(0,num2 - 1)
        //最后一位不相等，采用添加 结果变为 word1(0,num1) word2(0,num2 - 1)
        //不相等，采用删除 word1(0,num1-1) word (0 , num2)
        //交换 word1(0,num1 - 1) word2(0,num2 - 1)
        int num1=word1.length();
        int num2=word2.length();
        //空字符串
        if ((num1 * num2) == 0) return num1 + num2;

        //初始化
        int[][] dp=new int[num1 + 1][num2 + 1];
        for (int i = 0 ; i< num1 + 1 ; i++) dp[i][0]=i;
        for (int i = 0 ; i< num2 + 1 ; i++) dp[0][i]=i;

        //dp赋值
        for (int i = 1 ; i < num1 + 1 ; i++){
            for (int j = 1; j < num2 + 1 ; j++){
                int del=dp[i - 1][j]+1;
                int add=dp[i][j - 1]+1;
                int equ=dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    equ=equ+1;
                }
                dp[i][j]=Math.min(del,Math.min(add,equ));
            }
        }
        return dp[num1][num2];
    }
}
