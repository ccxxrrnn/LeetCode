package HashTable.String.wordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-16 11:27
 */


//290. 单词规律

// 哈希表
public class Test {
    public boolean wordPattern(String pattern, String s) {
        String[] arrays = s.split(" ");
        char[] chars = pattern.toCharArray();
        if(chars.length != arrays.length) return false;
        Map<Character,String> map = new HashMap<>();
        for (int i = 0 ; i < chars.length ; i++){
            if (map.containsKey(chars[i])){
                if (!map.get(chars[i]).equals(arrays[i])) return false;
            }else{
                if (map.containsValue(arrays[i])) return false;
                map.put(chars[i],arrays[i]);
            }
        }
        return true;
    }
}
