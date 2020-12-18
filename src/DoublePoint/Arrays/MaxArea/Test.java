package DoublePoint.Arrays.MaxArea;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 15:40
 **/

//11. 盛最多水的容器
public class Test {


    public int maxArea(int[] height) {
        int left = 0,right = height.length - 1,res = 0;
        while (left < right){
            int h;
            if (height[left] > height[right]){
                h = height[right--];
            }else{
                h = height[left++];
            }
            int area = h * (right - left + 1);
            res = Math.max(area,res);
        }
        return res;
    }

}
