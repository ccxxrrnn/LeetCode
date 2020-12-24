package HashTable.String.firstUniqChar;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-23 9:52
 */

//387. 字符串中的第一个唯一字符
public class Test {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[26];
        for (char c : chars){
            hash[c - 'a']++;
        }
        for (int i = 0 ; i < chars.length ; i++){
            if (hash[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
