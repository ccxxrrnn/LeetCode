package Top100.subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-01 9:28
 */

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ress = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs( nums , res , ress , 0 );
        return ress;
    }

    private void dfs(int[] nums, List<Integer> res, List<List<Integer>> ress, int i) {
        if (!ress.contains(res)) {
            ress.add(new ArrayList<>(res));
        }
        //退出
        if (i == nums.length){
            return;
        }
        for (int m = i ; m < nums.length ; m++){
            res.add(nums[m]);
            dfs(nums, res, ress, m + 1);
            res.remove(res.size() - 1);
        }
    }
}
