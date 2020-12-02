package Top100.grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-30 10:21
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    };

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(){{add(0);}};
        int head = 1;
        for (int i = 0 ; i < n ; i++){
            for (int j = res.size() - 1 ; j >= 0 ; j--){
                res.add(head + res.get(j));
            }
            head <<= 1 ;
        }
        return res;
    }
}
