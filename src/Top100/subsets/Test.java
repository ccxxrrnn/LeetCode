package Top100.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-16 8:55
 */

/**
 *给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    //栈


    //dfs
//    public List<List<Integer>> subsets(int[] nums) {
//        //
//        List<List<Integer>> resList = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        dfs(nums,0,res,resList);
//        return resList;
//    }

//    private void dfs(int[] nums, int i, List<Integer> res, List<List<Integer>> resList) {
//        if (!resList.contains(res)) resList.add(new ArrayList<>(res));
//        //终止
//        if (i == nums.length) return;
//        for ( ; i < nums.length ; i++) {
//            res.add(nums[i]);
//            dfs(nums, i + 1, res, resList);
//            res.remove(res.size() - 1);
//        }
//    }
}
