package Top100.addBinary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-09 8:52
 */


/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public String addBinary(String a, String b) {
       StringBuilder sb=new StringBuilder();
       int aPoint=a.length()-1;
       int bPoint=b.length()-1;
       int temp=0;
       while (aPoint>=0 || bPoint>=0){
           int aNum=0,bNum=0;
           if (aPoint>=0) {
               aNum = a.charAt(aPoint) - '0';
           }
           if (bPoint>=0) {
               bNum = b.charAt(bPoint) - '0';
           }
           int reNum=aNum+bNum+temp;
           if (reNum>1){
               reNum-=2;
               sb.insert(0,reNum);
               temp = 1;
           }else{
               sb.insert(0,reNum);
               temp=0;
           }
           aPoint--;
           bPoint--;
       }
       if (temp==1) sb.insert(0,1);
       return sb.toString();
    }
}
