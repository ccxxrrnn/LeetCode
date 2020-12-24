package Greedy.Arrays.candy;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-24 10:23
 */

//135. 分发糖果
public class Test {

    public int candy(int[] ratings) {
        int lenR = ratings.length;
        int[] res = new int[lenR];
        res[0] = 1;
        for (int i = 1 ; i < ratings.length ; i++){
            res[i]= 1;//默认发一块糖
            for (int j = i  ; j > 0 ; j--){
                //查看后面是否满足
                if (ratings[j - 1] > ratings[j]){
                    if (res[j - 1] > res[j]) break;
                    res[j - 1] += 1;//后面一位糖果加一
                    continue;
                }
                if (ratings[j - 1] < ratings[j]){
                    //比前者小，退出
                    if (res[j] > res[j - 1]) break;
                    res[j] = res[j - 1] + 1;
                    break;
                }
                if (ratings[j - 1 ] == ratings[j]){
                    break;
                }
            }
        }
        int num = 0;
        for (int i : res){
            num += i;
        }
        return num;
    }
}
