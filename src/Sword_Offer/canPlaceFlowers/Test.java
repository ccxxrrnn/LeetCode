package Sword_Offer.canPlaceFlowers;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2021-01-01 10:17
 */

//605. 种花问题
public class Test {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int lenF = flowerbed.length;
        int[] flowNew = new int[lenF + 2];
        flowNew[0] = 0;
        flowNew[flowNew.length - 1] = 0;
        if (lenF - 1 >= 0) System.arraycopy(flowerbed, 0, flowNew, 1, lenF);
        System.out.println(Arrays.toString(flowNew));

        int index = 1;
        while (index < lenF + 1){
            if (flowNew[index] == 0 && flowNew[index - 1] == 0 && flowNew[index + 1] == 0){
                flowNew[index] = 1;
                n--;
            }
            index++;
        }
        return n <= 0;
    }
}
