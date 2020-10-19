package Sword_Offer.MovingCount;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-13 9:55
 **/

/**
 * 000
 * 000
 */
public class Test {
    public static void main(String[] args) {
        Test test =new Test();
        System.out.println(test.movingCount(30,10,2));
    }

    int number=0;
    public int movingCount(int m, int n, int k) {
        int[][] ints=new int[m][n];
        help(ints,m,n,k,0,0);
        return number;
    }

    private void help(int[][] ints, int m, int n, int k, int i, int j) {
        if (i>m-1 || j>n-1 || i<0 || j<0 || (i/100%10+i/10%10+i%10)+(j/100%10+j/10%10+j%10)>k){
            return;
        }
        if (ints[i][j]==0){
            number++;
            ints[i][j]=1;
        }else{
            return;
        }
        help(ints,m,n,k,i+1,j);
        help(ints,m,n,k,i,j+1);
//        help(ints,m,n,k,i-1,j);
//        help(ints,m,n,k,i,j-1);
    }
}
