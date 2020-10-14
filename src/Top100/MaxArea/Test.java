package Top100.MaxArea;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 15:40
 **/

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且n的值至少为 2。

 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[] input=new int[]{1,8,6,2,5,4,8,3,7};
        int out=t.maxArea(input);
        System.out.println(out);
    }
//    public int maxArea(int[] height) {
//        int maxResult=0;
//        for (int i=1;i<height.length;i++){
//            for (int j=0;j<height.length-i;j++){
//                int h = Math.min(height[j], height[j + i]);
//                int compare=h*i;
//                if (compare>maxResult){
//                    maxResult=compare;
//                }
//            }
//        }
//        return maxResult;
//    }

    public int maxArea(int[] height){
        int left=0;
        int right=height.length-1;
        int maxResult=0;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int compare=h*(right-left);
            if (compare>maxResult){
                maxResult=compare;
            }
            if (height[right]>height[left]) left++;
            else right--;
        }
        return maxResult;
    }
}
