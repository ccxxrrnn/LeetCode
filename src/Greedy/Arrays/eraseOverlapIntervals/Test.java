package Greedy.Arrays.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-31 11:03
 */


//435. 无重叠区间
public class Test {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int lenI = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int end = intervals[0][1];
        for (int[] ints : intervals){
            int start = ints[0];
            if (start >= end){
                res++;
                end = ints[1];
            }
        }
        return lenI - res;
    }
}
