package Top100.LengthOfLongestSubstring;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 10:04
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String input="";
        int out= t.lengthOfLongestSubstring(input);
        System.out.println(out);
    }

    /**
     * 贪心算法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        List<String> maxResultList=new ArrayList<>();
        String[] strings=s.split("");
        for (String str:strings){
            if (!maxResultList.contains(str)){
                maxResultList.add(str);
            }
        }
        int maxResult=maxResultList.size();
        while(maxResult!=0){
            for (int i=0;i<=strings.length-maxResult;i++){
                ArrayList<String> testS=new ArrayList<>();
                String subS=s.substring(i,i+maxResult);
                for (String s1:subS.split("")){
                    if(!testS.contains(s1)){
                        testS.add(s1);
                    }else{
                        break;
                    }
                }
                if (testS.size()==maxResult){
                    return maxResult;
                }
            }
            maxResult--;
        }
        return maxResult;
    }
    /**
     * 双指针+滑动窗口
     */
}
