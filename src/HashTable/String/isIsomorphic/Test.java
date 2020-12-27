package HashTable.String.isIsomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-27 10:34
 */

//205. 同构字符串
public class Test {

    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (!map.containsKey(cS)){
                if (!map.containsValue(cT)) {
                    map.put(cS, cT);
                }else{
                    return false;
                }
            }else if (!(map.get(cS) == cT)){
                return false;
            }
        }
        return true;
    }

}
