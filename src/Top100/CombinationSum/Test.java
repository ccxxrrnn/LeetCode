package Top100.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-28 10:00
 */

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先排序,回溯,剪枝
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
            ress.add(res);
            return;
        }
        for (int i=m;i<candidates.length;i++){
            if (candidates[i]<=target) {
                List<Integer> trylist=new ArrayList<>(res);
                trylist.add(candidates[i]);
                dfs(candidates, target - candidates[i], trylist, ress,i);
            }
        }
    }
}
