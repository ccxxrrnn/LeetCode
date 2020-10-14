package Top100.Reverse;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 10:21
 **/

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int input=1534236469;
        int out=t.reverse(input);
        System.out.println(out);
    }

    public int reverse(int x) {
        long out=0;
        while(x!=0){
            int m=x%10;
            x=x/10;
            out=out*10+m;
        }
        if(out!=(int)out){
            return 0;
        }
        return (int) out;
    }
}
