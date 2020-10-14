package Top100.Convert;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 9:02
 **/

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String input="AB";
        String out= t.convert(input, 1);
        System.out.println(out);
    }
    public String convert(String s, int numRows) {
        StringBuffer stringBuffer=new StringBuffer();
        ArrayList<String> arrayList=new ArrayList<>();
        if (numRows==1) return s;
        int interval=2*numRows-2;
        for (int i=0;i*interval<s.length();i++) {
            if (i * interval + interval > s.length()) {
                arrayList.add(s.substring(i * interval));
            } else {
                arrayList.add(s.substring(i * interval, i * interval + interval));
            }
        }
        int left=0;
        int right=interval;
        while(left<=right) {
            for (String s1 : arrayList) {
                if (left==right && left<s1.length()){
                    stringBuffer.append(s1.charAt(left));
                    continue;
                }
                if (left<s1.length()) {
                    stringBuffer.append(s1.charAt(left));
                }
                if (right < s1.length()) {
                    stringBuffer.append(s1.charAt(right));
                }
            }
            left++;
            right--;
        }
        return stringBuffer.toString();
    }
}
