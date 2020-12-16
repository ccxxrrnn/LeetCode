package sliding_window.LengthOfLongestSubstring;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 10:04
 **/

import java.util.ArrayDeque;
import java.util.Deque;


//3. 无重复字符的最长子串
//贪心
//滑动窗口
public class Test {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        int res = 0;
        for (char aChar : chars) {
            if (deque.contains(aChar)) {
                if (deque.size() > res) {
                    res = deque.size();
                }
                while (deque.contains(aChar)) {
                    deque.removeFirst();
                }
            }
            deque.addLast(aChar);
        }
        return res;
    }

//    /**
//     * 贪心算法
//     * @param s
//     * @return
//     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length()==0) return 0;
//        List<String> maxResultList=new ArrayList<>();
//        String[] strings=s.split("");
//        for (String str:strings){
//            if (!maxResultList.contains(str)){
//                maxResultList.add(str);
//            }
//        }
//        int maxResult=maxResultList.size();
//        while(maxResult!=0){
//            for (int i=0;i<=strings.length-maxResult;i++){
//                ArrayList<String> testS=new ArrayList<>();
//                String subS=s.substring(i,i+maxResult);
//                for (String s1:subS.split("")){
//                    if(!testS.contains(s1)){
//                        testS.add(s1);
//                    }else{
//                        break;
//                    }
//                }
//                if (testS.size()==maxResult){
//                    return maxResult;
//                }
//            }
//            maxResult--;
//        }
//        return maxResult;
//    }

}
