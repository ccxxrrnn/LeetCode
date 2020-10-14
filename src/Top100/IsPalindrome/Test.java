package Top100.IsPalindrome;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 15:20
 **/

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int input=355555553;
        System.out.println(t.isPalindrome(input));
    }
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x==0) return true;
        int compleX=0;
        int copyX=x;
        while(x!=0){
            int i=x%10;
            x=x/10;
            compleX=compleX*10+i;
        }
        return compleX==copyX;
    }
}
