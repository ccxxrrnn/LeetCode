package Greedy.Int.monotoneIncreasingDigits;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-21 11:17
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public int monotoneIncreasingDigits(int N) {
        for (int i = N, j = 9, k = 1; i > 0; i /= 10, k *= 10)
            if (j < (j = i % 10))// 如果后一位比前一位小
                // 以332为例，第1次走到这一步的时候 i=33,k=10, 329进入递归
                // 第2次走到这一步的时候 i=3,k=100, 299进入递归
                return monotoneIncreasingDigits(i * k - 1);
        // 299递归出口
        return N;
    }
}
