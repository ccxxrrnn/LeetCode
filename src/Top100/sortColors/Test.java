package Top100.sortColors;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-12 9:59
 */

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？   && 双指针
 *
 */


public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[] out = new int[]{2,2};
        t.sortColors(out);
        System.out.println(Arrays.toString(out));
    }

    public void sortColors(int[] nums) {
        int[] numArray = new int[3];
        for (int num : nums) {
            numArray[num]++;
        }
        int index = 0;
        for (int i = 0;i < numArray.length;i++){
            while (numArray[i] != 0){
                nums[index] = i;
                numArray[i] -= 1;
                index++;
            }
        }
    }

//    public void sortColors(int[] nums) {
//        //迭代 计数
//        int[] numFlower=new int[3];
//        int[] indexFirst=new int[2];
////        int index0First = 0;  //红花结束位置  如果红花少了，蓝花多了，那么 this+1 =0   else this = 1
////        int index1First = 0; //白花结束位置   同理 this+1 = 1     this = 2
//        //假设花可以为负数 ，暂时借一朵花和存一朵花，
//        // 假设第一支花不为红花那么需要存一支白或者蓝花，
//        // 即出现前后花不一致就主动改变花
//        int drawClo=0;//画画的颜色1
//        for (int i = 0;i < nums.length ; i++) {
//            if (nums[i] == drawClo + 1) {//进阶为下一个颜色
//                indexFirst[drawClo] = i;
//                drawClo = drawClo + 1;
//            }
//            if (nums[i] != drawClo) {//颜色bu相同，改变值 记录
//                numFlower[nums[i]]++;
//                nums[i] = drawClo;
//                numFlower[drawClo]--;
//            }
//            //最后就是颜色相同 不改变也不存取
//        }
////        System.out.println(Arrays.toString(indexFirst));
////        System.out.println(Arrays.toString(numFlower));
////        System.out.println(Arrays.toString(nums));
//        //这时候花都是清一色的 ，需要做出改变
//        for (int i = 0; i < numFlower.length  ;i++){
//            System.out.println(Arrays.toString(numFlower));
//            System.out.println(Arrays.toString(nums));
//            //表示这种颜色完美 ==0 ,
//            //<0  因为是相邻借取的关系 ， 所以简单来说就是红花多了
//            while(numFlower[i] < 0){
//                nums[indexFirst[i]] = i + 1;
//                //最后的坐标移动
//                indexFirst[i] +=1;
//                numFlower[i]++;
//                numFlower[i + 1]--;
//            }
//            //红花少了
//            while (numFlower[i] > 0){
//                nums[indexFirst[i] - 1] = i;
//                indexFirst[i] -=1;
//                numFlower[i]--;
//                numFlower[i + 1]++;
//            }
//        }
//    }
}
