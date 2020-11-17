package Top100.RemoveDuplicates;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-17 9:15
 */

public class Test2 {

    public static void main(String[] args) {
        Test2 t = new Test2();
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            //i < 2 直到遇见新的值
            if (i < 2 || n > nums[i-2]) nums[i++] = n;
        }
        return i;
    }
}
