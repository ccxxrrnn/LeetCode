package Math.Arrays.canEat;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2021-06-01 15:52
 */

//1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
//long数据类型，int溢出
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        System.out.println(Arrays.toString(t.canEat(new int[]{5, 2, 6, 4, 1}, new int[][]{{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}})));
//        System.out.println(Arrays.toString(t.canEat(new int[]{7,4,5,3,8}, new int[][]{{0,2,2}, {4,2,4}, {2,13,1000000000}})));
        System.out.println(Arrays.toString(t.canEat(new int[]{7,11,5,3,8}, new int[][]{{2,2,6}})));
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        //改造糖果
        for (int i = 1 ; i < candiesCount.length ; i++){
            sum[i] = candiesCount[i] + sum[i - 1];
        }
        //只需要证明在最小到最少中间就可以
        int lenQue = queries.length;
        boolean[] res = new boolean[lenQue];
        for (int i = 0 ; i < lenQue ; i++){
            int[] queS = queries[i];
            int favoriteTypei = queS[0];
            int favoriteDayi = queS[1];
            int dailyCapi = queS[2];
            long  left = favoriteTypei == 0 ? 1 : sum[favoriteTypei - 1] + 1;
            long  right = sum[favoriteTypei];
            long  minCandy =  favoriteDayi + 1;
            long  maxCandy = minCandy * dailyCapi;
            res[i] = minCandy <= right && maxCandy >= left;
        }
        return res;
    }
}
