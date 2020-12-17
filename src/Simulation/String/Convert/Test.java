package Simulation.String.Convert;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 9:02
 **/

//6. Z 字形变换
public class Test {


    public String convert(String s, int numRows) {
        String[] charRes = new String[numRows];
        Arrays.fill(charRes, "");
        if (numRows == 1 ) return s;
        char[] chars = s.toCharArray();
        int i = 0 ;
        int index = 0 ;
        while (i < chars.length){
            while (i < chars.length && index < numRows ) {
                charRes[index] += chars[i];
                i++;
                index++;
            }
            index -= 2;
            while (i < chars.length && index >= 0) {
                charRes[index] += chars[i];
                i++;
                index--;
            }
            index += 2;
        }
        StringBuilder res = new StringBuilder();
        for (String s1 : charRes){
            res.append(s1);
        }
        return res.toString();
    }


}
