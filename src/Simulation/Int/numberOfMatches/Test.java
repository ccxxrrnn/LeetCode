package Simulation.Int.numberOfMatches;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-17 12:03
 */

//1688. 比赛中的配对次数
public class Test {
    public int numberOfMatches(int n) {
        int res = 0;
        while(n != 1){
            res += n / 2 ;
            if((n & 1 ) == 1){
                n = n /2 + 1;
            }else{
                n = n / 2;
            }
        }
        return res ;
    }
}
