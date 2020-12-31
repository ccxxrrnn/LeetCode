package PriorityQueue.Arrays.lastStoneWeight;

import java.util.*;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-30 11:11
 */

//1046. 最后一块石头的重量
public class Test {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
