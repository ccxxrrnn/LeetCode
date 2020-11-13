package Top100.combine;

import java.util.*;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-13 11:09
 */

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.combine(4, 2).toString());
    }

    public List<List<Integer>> combine(int n, int k) {
        //回溯
        List<List<Integer>> resList=new ArrayList<>();
        Deque<Integer> list=new ArrayDeque<>();
        dfs(resList,list,n,k,1);
        return resList;
    }

    private void dfs(List<List<Integer>> resList, Deque<Integer> list, int n, int k, int i) {
        if (list.size() == k){
            resList.add(new ArrayList<>(list));
            return;
        }
        for (;i <= n - (k - list.size()) + 1;i++){
            list.addLast(i);
            dfs(resList, list, n , k, i + 1);
            list.removeLast();
        }
    }


}
