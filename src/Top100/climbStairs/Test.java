package Top100.climbStairs;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-10 9:41
 */


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int climbStairs(int n) {
        //全部分散为1 相邻的结合组成 2 就是一种情况 深度 or 广度 复杂度
//        if (n == 0 ) return 1;
//        if (n < 0 ) return 0;
//        int res = 0;
//        //尝试走一步
//        res=res+climbStairs(n-1);
//        //尝试二步
//        res=res+climbStairs(n-2);
//        return res;
//       斐波那契数列 1 1 2 3 5
        if (n <= 2){
            return n;
        }
        int res = 0;
        int f1 = 1; //走一步
        int f2 = 2;
        for (int i = 2;i < n ; i++){
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
