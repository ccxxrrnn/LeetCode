package Top100.CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-28 10:30
 */

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先排序,回溯
        //找到首位，判断是否==target >则退出
        //回溯 终止条件 target==0
        Arrays.sort(candidates);
        List<List<Integer>> ress=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        dfs(candidates,target,res,ress,0);
        return ress;
    }

    private void dfs(int[] candidates, int target, List<Integer> res, List<List<Integer>> ress,int m) {
        if (target==0){
            if(!ress.contains(res)){
                ress.add(res);
            }
            return;
        }
        for (int i=m;i<candidates.length;i++){
            if (candidates[i]<=target ) {
                List<Integer> trylist=new ArrayList<>(res);
                trylist.add(candidates[i]);
                dfs(candidates, target - candidates[i], trylist, ress,i+1);
            }
        }
    }
}
