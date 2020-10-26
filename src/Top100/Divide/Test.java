package Top100.Divide;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-26 9:17
 **/

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数dividend除以除数divisor得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 
 *
 * 示例1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * 
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231− 1
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.divide(-214748364,2);
        System.out.println(res);
    }

    public int divide(int dividend, int divisor) {
        boolean flag=false;  //false为负数，true为正数
        if (dividend==0) return 0;
        if(divisor==1) return dividend;
        if(divisor==-1) return -dividend==-(long)dividend?-dividend:Integer.MAX_VALUE;
        if((dividend<0 && divisor<0) || (dividend>0 && divisor>0)){
            flag=true;
        }
        int x=-Math.abs(dividend);
        int y=-Math.abs(divisor);
        int res=abs(x,y);// 除数，被除数
        return flag ? res : -res;
    }

    private int abs(int x, int y) {
        if (x>y) return 0;
        int t=y;
        int temp=1;
        while(t+t>x &&t+t<0){
            t=t+t;
            temp=temp+temp;
        }
        return temp+abs(x-t,y);
    }
}
