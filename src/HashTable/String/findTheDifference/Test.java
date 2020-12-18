package HashTable.String.findTheDifference;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-18 10:04
 */


//389. 找不同
public class Test {


    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0 ; i < s.length() ; i++){
            hash[s.charAt(i) - 'a' ]++;
            hash[t.charAt(i) - 'a' ]--;
        }
        hash[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0 ; i < hash.length ; i++){
            if (hash[i] == -1) return (char)('a' + i);
        }
        return ' ';
    }
}
