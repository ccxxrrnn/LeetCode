package Top100.numDecodings;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-02 11:29
 */

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 *
 * 输入：s = "2"
 * 输出：1
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length() + 1]; //字符串长度为n时有多少种，最终解为dp[s.length()]
        //初始化
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2 ; i < s.length() + 1 ; i++){
            //如果当前字符为0 那么上一个字符必须为 1 or 2 加入为其他的因为无法编译 例如 30 40 无法分开
            if (s.charAt(i - 1) == '0'){
                //如果满足 20 10 那么不可分
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2'){
                    dp[i] = dp[i - 2];
                }else{
                    return 0;
                }
            }
            else if (s.charAt(i - 2) == '1' ||(s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
