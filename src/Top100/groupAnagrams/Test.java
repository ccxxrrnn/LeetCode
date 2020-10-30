package Top100.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-30 9:10
 */

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        List<List<String>> res=t.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //构建hash表，如果相同就存入list，将值置为-
        List<List<String>> ress=new ArrayList<>();
        int[][] hash=new int[strs.length][32]; //字幕出现的次数
        for (int i=0;i<strs.length;i++){
            for (int j=0;j<strs[i].length();j++){
                hash[i][strs[i].charAt(j)-'a']+=1;
            }
        }
        for (int i=0;i<hash.length;i++){
            if (hash[i][0]==-1) continue;
            List<String> res=new ArrayList<>();
            res.add(strs[i]);
            for(int j=i+1;j<hash.length;j++){
                if (hash[j][0]==-1) continue;
                if (Arrays.equals(hash[i],hash[j])){ //判断hash是否相等  ace bcd
                    res.add(strs[j]);
                    hash[j][0]=-1;
                }
            }
            ress.add(res);
        }
        return ress;
    }
}
