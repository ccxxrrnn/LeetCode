package Sword_Offer.MyPow;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-13 10:57
 **/
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Double n= test.myPow(2,-2147483648);
        System.out.println(n);
    }
    public double myPow(double x, int n) {
        double x1;
        int i;
        long f=n;
        if (x==0){
            return 0;
        }
        if (x==1){
            return x;
        }
        if (x == -1){
            return n%2==0?1:-1;
        }
        if (n==0){
            return 1;
        }
        if (f<0){
            x=1/x;
            f=-f;
        }
        if (f > 0) {
            double b = x;
            for (i = 0; i < f - 1; i++) {
                x1=x;
                x *= b;
                if (x1==x){
                    return x;
                }
            }
            return x;
        }
        return x;
    }
}
