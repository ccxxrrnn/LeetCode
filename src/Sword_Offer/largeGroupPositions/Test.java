package Sword_Offer.largeGroupPositions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2021-01-05 19:08
 */


//830. 较大分组的位置
public class Test {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        int lenS = chars.length;
        List<List<Integer>> res = new ArrayList<>();
        while (index < lenS){
            int start = index;
            while (index < lenS - 1 && chars[index] == chars[index + 1]) index++;
            if (index - start >= 2){
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(index);
                res.add(list);
            }
            index++;
        }
        return res;
    }
}
