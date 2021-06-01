package HashTable.Arrays.generateMatrix;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-03 14:20
 */


//59. 螺旋矩阵 II
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[][] res = t.generateMatrix(5);
        for (int[] re :res){
            System.out.println(Arrays.toString(re));
        }
    }

    //first
//    public int[][] generateMatrix(int n) {
//        //模拟涂写过程
//        int[][] res=new int[n][n]; //结果
//        int maxNum=n*n;    //最大数
//        //结束条件 画完所有图
//        int temp=0;  //记录画的次数
//        int i=0;  //横坐标
//        int j=0;  //纵坐标
//        while (temp!=maxNum){
////            System.out.println(Arrays.deepToString(res));
//            //画起始
//            temp++;
//            res[i][j]=temp;
//            //往右画
//            while(j+1<n && res[i][j+1]==0){
//                temp++;
//                j++;
//                res[i][j]=temp;
//            }
//            while (i+1<n && res[i+1][j]==0){
//                temp++;
//                i++;
//                res[i][j]=temp;
//            }
//            while(j-1>=0 && res[i][j-1]==0){
//                temp++;
//                j--;
//                res[i][j]=temp;
//            }
//            while(i-1>=0 && res[i-1][j]==0){
//                temp++;
//                i--;
//                res[i][j]=temp;
//            }
//            //最后左移找到下一个范围的起始
//            j++;
//        }
//        return res;
//    }

    //second
    public int[][] generateMatrix(int n) {
        int[][] resArr = new int[n][n];
        int num = 1,j = 0;
        while( num <= n * n){
            for(int i = j ; i < n - j ; i++) resArr[j][i] = num++;
            for(int i = j + 1 ; i < n - j ; i++) resArr[i][n - j - 1] = num++;
            for(int i = n - j - 2 ; i >= j ; i--) resArr[n - j - 1][i] = num++;
            for(int i = n - j - 2; i > j ; i--) resArr[i][j] = num++;
            j++;
        }
        return resArr;
    }
}
