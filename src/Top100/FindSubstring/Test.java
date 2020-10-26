package Top100.FindSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-26 10:28
 **/

/**
 * 给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        List<Integer> res=t.findSubstring("aab", new String[]{"a","b"});
        System.out.println(res.toString());
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
//        int sidesize=0;//滑动窗口大小
        int sidesize=words[0].length();
        int allsize=words.length*sidesize;
        Map<String,Integer> map =new HashMap<>(); //存放字符串和次数
        for(String s1:words){
            map.put(s1,map.getOrDefault(s1, 0)+1); //如果有就加一，没有就默认
        }
        System.out.println(map.toString());
        Map<String, Integer> judmap = new HashMap<>(map);   //临时map
        for(int i=0;i<s.length()-allsize+1;i++){
            //1、赋值准备，循环开始
            //2、拿到窗口的值，判断map中是否有值，value是否可以减？Value-- : break
            //3、窗口右移 再截取判断，开启下一循环
            // 4、循环结束，如果j-i等于全部size，将首位值加入到res
            int j=i+sidesize;
            int k=i;
            while (j-i<=allsize){
                String judgestr=s.substring(k,j);
                if (judmap.containsKey(judgestr) && judmap.get(judgestr)>0){
                    judmap.put(judgestr, judmap.get(judgestr)-1);
                }else{
                    judmap.putAll(map);
                    break;
                }
                k=j;
                j=k+sidesize;
            }
            if(j-i-sidesize==allsize) {
                res.add(i);
                judmap.putAll(map);
            }
        }
        return res;
    }
}
