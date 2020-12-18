package Simulation.String.longestCommonPrefix;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-18 10:47
 */

//14. 最长公共前缀
public class Test {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (strs.length == 0 ) return res.toString();
        int index = 0;
        boolean flag = false;
        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if ((index > strs[i].length() - 1) || strs[i].charAt(index) != c){
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            res.append(c);
            index++;
        }
        return res.toString();
    }
}
