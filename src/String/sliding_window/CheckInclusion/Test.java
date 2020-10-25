package String.sliding_window.CheckInclusion;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-24 14:46
 **/

import java.util.Arrays;

/**
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间

 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        boolean b=t.checkInclusion("abc","babc");
        System.out.println(b);
    }
// abc babc
    public  boolean checkInclusion(String s1, String s2) {
        int[] hash=new int[26];
        for (int i=0;i<s1.length();i++){
            hash[s1.charAt(i)-'a']++;  //计算hash值
        }
        int size=0;
        for (int i:hash){
            if (i!=0) size++; //字母类别
        }
        char[] c=s2.toCharArray();
        int temp=0; //匹配的字母类别
        for (int i=0,j=0;i<s2.length();i++){  //i为右窗口，j为左窗口
            if (--hash[c[i]-'a']==0)  temp++;  //所有进来的数先进来减少，为0则表示在s1中有这个值此时被完全消耗尽了
            if (i-j+1>s1.length()){  //因为窗口大小固定，达到窗口上限，要决定匹配的字母类别是否正确
                if (hash[c[j]-'a']==0) temp--;  //因为要恢复，假如恢复了s2中的值，已完成的字母类别就没有完成
                hash[c[j++]-'a']++; //窗口向右移，恢复左窗口的值
            }
            System.out.println(Arrays.toString(hash));
            System.out.println(temp);
            if (temp==size) return true;
        }
        return false;
    }

}
