package Top100.fullJustify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-09 10:00
 */


/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20).toString());

    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int rowWidth=0;
        StringBuilder sb=new StringBuilder("");
        for (String s:words){
            sb.append(s).append(" ");
            rowWidth=sb.length(); //单词加空格
//            System.out.println(sb.toString());
//            System.out.println(rowWidth);
            if (rowWidth==maxWidth+1){
                sb.delete(sb.length()-2-s.length(),sb.length()-1);
                res.add(sb.toString().trim());
                sb=new StringBuilder(s+" ");
                rowWidth=0;
            }else if (rowWidth>maxWidth+1){
                sb.delete(sb.length()-2-s.length(),sb.length()-1);
                StringBuilder newSb=new StringBuilder("");
                List<String> strings = Arrays.asList(sb.toString().trim().split(" "));
                int spaceNums=maxWidth-sb.length()+strings.size(); //最后一行空格
                while(spaceNums>0){
                    for (int i=0;i<strings.size()-1;i++){//最后一个不用加
                        if (spaceNums>0){
                            String replaceS=strings.get(i)+" ";
                            strings.set(i,replaceS);
                            spaceNums--;
                        }else{
                            break;
                        }
                    }
                }
                for (String s1:strings){
                    newSb.append(s1);
                }
                res.add(newSb.toString());
                //重置下一行
                sb=new StringBuilder(s+" ");
                rowWidth=0;
            }
        }
        //最后一行
        int spaceNums=maxWidth-sb.length();
        while (spaceNums>0) {
            sb.append(" ");
            spaceNums--;
        }
        res.add(sb.toString());
        return res;
    }
}
