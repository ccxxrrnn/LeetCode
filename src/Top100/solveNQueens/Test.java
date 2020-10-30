package Top100.solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-30 10:05
 */

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        List<List<String>> res=t.solveNQueens(4);
        System.out.println(res.toString());
    }

    public List<List<String>> solveNQueens(int n) {
        //结束条件 ： n个皇后放完  //棋子放不下了 ，位置被占满
        List<List<String>> reslist= new ArrayList<>(); //结果集
        String[][] board=new String[n][n];
        dfs(reslist,n,n,board); // 棋盘 行数  可放棋子 棋盘
        return reslist;
    }

    private void dfs(List<List<String>> resList, int cow,  int n, String[][] board) {
        //结束条件
        if (n==0){ //补全图
            List<String> res=new ArrayList<>();
            for (String[] strings:board){
                StringBuilder sb=new StringBuilder("");
                for (String s:strings){
                    if (s==null){
                        sb.append(".");
                    }else {
                        sb.append(s);
                    }
                }
                res.add(sb.toString());
            }
            resList.add(res);
            return;
        }
        //尝试放一行，因为横列不可以相等，所以每一行假设放第一个
        for (int m=0;m<cow;m++){
            String[][] copyBoard = new String[cow][cow];
            for (int i=0;i<board.length;i++){
                copyBoard[i]=Arrays.copyOf(board[i],board.length);
            }
            if ( board[cow-n][m]!=null && board[cow-n][m].equals(".") ) continue;
            board[cow-n][m]="Q";//绘图
            //绘制坐标中行不符合
            int t=1;
            for (int i=cow-n+1;i<board.length;i++) {
                board[i][m] = ".";//竖不符合
                //斜不符合
                if (m - t >= 0) {
                    board[i][m - t] = ".";
                }
                if (m + t < board.length) {
                    board[i][m + t] = ".";
                }
                t++;
            }
            dfs(resList, cow, n-1, board);  //进入第二行寻找
            //下一个,恢复现场
            board=copyBoard;
            board[cow-n][m]=".";

        }
    }
}
