package Simulation.String.minPartitions;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-17 12:10
 */

//1689. 十-二进制数的最少数目
public class Test {

    public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        int max = 0;
        for (char c : chars){
            max = Math.max(max,c - '0');
        }
        return max;
    }
}
