package Top100.mySqrt;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-10 9:01
 */

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        // n * n = x
//        for循环
        for (int i=0;i<=x;i++){
            int nextNum= ( i + 1 ) * ( i + 1);
            //i至少为0 不可能为负数 ， 除非越界
            if (nextNum < 0)  return i;
            //处理 0 1 情况 恰好相等
            if (x == i *i) return i;
            //去尾
            if (x > i * i && x < nextNum){
                return i;
            }
        }
        //几乎不可达
        return 0;
    }
//
//        //指数增长
//        double i =Math.sqrt(x);
}
