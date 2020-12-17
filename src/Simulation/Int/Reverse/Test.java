package Simulation.Int.Reverse;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 10:21
 **/

//7. 整数反转
public class Test {

    public int reverse(int x) {
        long out = 0;
        while(x != 0){
            int m = x % 10;
            x = x / 10;
            out = out * 10 + m;
        }
        if(out != (int)out){
            return 0;
        }
        return (int) out;
    }
}
