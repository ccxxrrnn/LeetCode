package Simulation.Int.IsPalindrome;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 15:20
 **/


//9. 回文数
public class Test {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int comX = 0;
        int copyX = x;
        while (x != 0){
            int i = x % 10;
            x /= 10;
            comX = comX * 10 + i;
        }
        return comX == copyX;
    }

}
