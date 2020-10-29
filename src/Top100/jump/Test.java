package Top100.jump;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-29 9:33
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int res=t.jump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5});
        System.out.println(res);
    }

//    int jumpnum;  //现在跳跃的次数
//    boolean flag=true;    // 假如最大值都跳不成功，那么后面就没有必要了
    public int jump(int[] nums) {
        //回溯  记录已经跳过的最小值  动态规划
        //终止条件 到达终点 （超过当前最小值了）
        //dp 超时
        //贪心
//        jumpnum=nums.length-1;
//        dfs(nums,0,0);  //数组 现在的位置 跳跃次数
//        return jumpnum;
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

//    private void dfs(int[] nums, int index, int num) {
////        flag=true;//默认都可以跳
//        if (num>=jumpnum-1) {
//            flag=false; //再跳就超过最小值了
//            return;
//        }
//        if (index==nums.length-1){
//            jumpnum=num;
//            return;
//        }
//        int t=Math.min(nums.length-index-1,nums[index]);
//        for (int i=t;i>0;i--){
//            dfs(nums,index+i,num+1);
//            if (!flag){
//                flag=true; //还原
//                break;
//            }
//        }
//    }

}
