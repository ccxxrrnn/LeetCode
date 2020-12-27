package Greedy.Arrays.findContentChildren;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-25 9:24
 */

//455. 分发饼干
public class Test {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int lenG = g.length;
        int lenS = s.length;
        int index = lenS - 1;
        int res = 0;
        for (int i = lenG - 1 ; i >= 0 ; i--){
            if (index >= 0 && s[index] >= g[i]) {
                res++;
                index--;
            }
            if (index < 0) return res;
        }
        return res;
    }
}
