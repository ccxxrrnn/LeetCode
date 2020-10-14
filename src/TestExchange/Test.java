package TestExchange;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-14 15:26
 **/
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        int[] is=new int[]{1, 2, 3, 4,6,7,9,11};
        is=t.exchange(is);
        System.out.println(Arrays.toString(is));
    }
    public int[] exchange(int[] nums) {
        int first=0,last=nums.length-1;
        while(first<last){
            if ((nums[first] & 1)==1){
                first++;continue;
            }
            if ((nums[last] & 1)==0){
                last--;continue;
            }
            swap(first,last,nums);
        }
        return nums;
    }

    private  void swap(int i,int j,int[] ints){
        int m=ints[i];
        ints[i]=ints[j];
        ints[j]=m;
    }
}
