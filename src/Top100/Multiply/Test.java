package Top100.Multiply;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-24 15:29
 **/

/**
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1和num2的长度小于110。
 * num1 和num2 只包含数字0-9。
 * num1 和num2均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String s=t.multiply("123", "456");
        System.out.println(s);
    }

    //123 45
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        int[] res=new int[num1.length()+num2.length()];
        for (int i=0;i<num1.length();i++){
            int a=num1.charAt(i)-'0';
            for (int j=0;j<num2.length();j++){
                int b=num2.charAt(j)-'0';
                int s=res[i+j+1]+b*a;
                res[i+j]+=s/10;
                if (res[i+j]>=10){
                    int t=i+j;
                    while(res[t]>=10){
                        res[t]-=10;
                        res[t-1]+=1;
                        t--;
                    }
                }
                res[i+j+1]=s%10;
//                System.out.println(s);
//                System.out.println(Arrays.toString(res));
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i:res){
            if (sb.length()==0 && i==0){
                continue;
            }
            sb.append(i);
        }
        return sb.toString();
    }
}
