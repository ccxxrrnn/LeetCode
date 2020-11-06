package Top100.plusOne;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-06 10:20
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while(digits[i]+1>=10){
            digits[i]-=9;
            i--;
            if (i<=-1){
                break;
            }
        }
        if (i!=-1 && digits[i]+1<10){
            digits[i]=digits[i]+1;
            return digits;
        }
        int[] res=new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
