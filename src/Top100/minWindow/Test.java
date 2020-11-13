package Top100.minWindow;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-13 8:55
 */

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.minWindow("aaaabbbccccdddd", "abcd"));
    }

    //My
    public String minWindow(String s, String t) {
        //哈希表和双指针
        int low=0; //慢指针
        int fast=0; //快指针
        int[] hash=new int[72]; //字典哈希表
        int[] hashCompare=new int[72]; //对比哈希表
        boolean flag=false;
        //初始化字典哈希表
        for (int i = 0;i < t.length();i++){
            hash[t.charAt(i) - 'A']++;
        }
        //滑动指针
        String res = s;
        while(fast < s.length()){
            //移动慢指针找到开始
            while(low < s.length() && hash[s.charAt(low) - 'A'] == 0 ){
                low++;
            }
            fast = Math.max(fast,low);
            //移动快指针，直到hash表全为0
            //假如
            while(fast < s.length() && !Arrays.equals(hash, hashCompare)){
                //假如不同
                int fastInt=s.charAt(fast) - 'A';
                if (hash[fastInt] != hashCompare[fastInt]){
                    hashCompare[fastInt]++;
                }else if (hash[fastInt] == 1){
        //假如相同，则证明还没到终点，就出现重复,慢指针需要找到重复的点，消除重复
                    while(low < s.length() && s.charAt(low) != s.charAt(fast)){
                    //二值相等,需要还原
                    if (hashCompare[s.charAt(low) - 'A'] != 0){
                        hashCompare[s.charAt(low) - 'A']--;
                    }
                    low++;
                    }
                    //最后加一
                    low++;
                    fast++;
                    break;
                }
                fast++;
            }
            if (fast <= s.length() && Arrays.equals(hash, hashCompare) && (fast - low) <= res.length()) {
                res = s.substring(low,fast);
                flag = true;
            }
            //寻找更优解
            //释放慢指针的开始
            if (Arrays.equals(hash, hashCompare) && low < s.length()) {
                hashCompare[s.charAt(low) - 'A']--;
                low++;
            }
        }
        return flag?res:"";
    }

//    other
//    public String minWindow(String s, String t) {
//        int[] window = new int[128], need = new int[128];
//        char[] ss = s.toCharArray(), tt = t.toCharArray();
//        int count = 0, min = ss.length;
//        String res = "";
//        for (int i = 0; i < tt.length; i++) {
//            need[tt[i]]++;
//        }
//        int i = 0, j = 0;
//        while(j < ss.length) {
//            char c = ss[j];
//            window[c]++;
//            if (window[c] <= need[c]) count++;
//            while(count == tt.length) {
//                if (j - i + 1 <= min){
//                    res = s.substring(i, j + 1);
//                    min = j - i + 1;
//                }
//                window[ss[i]]--;
//                if (window[ss[i]] < need[ss[i]]) count--;
//                i++;
//                if (i >= ss.length) break;
//            }
//            j++;
//        }
//        return res;
//    }
}

