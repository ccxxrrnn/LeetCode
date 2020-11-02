package Top100.merge;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-02 8:56
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public List<List<Integer>> merge(List<List<Integer>> intervals) {
        //首先选取第一个区间最右为比较值
        // 假如比较值<下一个区间的 那么重新选择比较值
        //否则合并，选择 比较值和，合并值的最右边
        List<List<Integer>> res=new ArrayList<>();
        int right=intervals.get(0).get(1);
        int left=intervals.get(0).get(0);
        for (List<Integer> list:intervals){
            int compareRight=list.get(1);
            int compareLeft=list.get(0);
            if (right>=compareLeft){//需要合并
                left=Math.max(compareLeft,left);
            }else{
                List<Integer> li=new ArrayList<>();
                li.add(left);
                li.add(right);
                res.add(li);
                right=compareRight;
                left=compareLeft;
            }
        }
        return res;
    }
}
