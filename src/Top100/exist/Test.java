package Top100.exist;

import java.util.Arrays;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-16 9:29
 */

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.exist(new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        }, "CAAADCAAB"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                //找到起点
                if (board[i][j] == word.charAt(0)){
                    //起始坐标开始坐标
                    if(dfs(i,j,board,word,new int[board.length][board[0].length],0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int[][] map, int k) {
//        System.out.println(k);
        if (k == word.length() - 1) return true; //可以到达终点
        map[i][j] = 1; //绘制地图防止重复
        if (i + 1 < board.length && map[i + 1][j] != 1 &&word.charAt(k + 1) == board[i + 1][j]){
            if (dfs(i + 1, j, board, word, map, k + 1)){
                return true;
            }else{
                map[i + 1][j] = 0;
            }
        }
        if (i - 1 >= 0 && map[i - 1][j] != 1 &&word.charAt(k + 1) == board[i - 1][j]){
           if (dfs(i - 1, j, board, word, map, k + 1)){
               return true;
           }else{
               map[i - 1][j] = 0;
           }
        }
        if (j - 1 >= 0 && map[i][j - 1] != 1 &&word.charAt(k + 1) == board[i][j - 1]){
            if ((dfs(i, j - 1, board, word, map, k + 1))){
                return true;
            }
            else{
                map[i][j - 1] = 0;
            }
        }
        if (j + 1 <board[0].length && map[i][j + 1] != 1 &&word.charAt(k + 1) == board[i][j + 1]){
            if (dfs(i, j + 1, board, word, map, k + 1)){
                return true;
            }else{
                map[i][ j + 1] = 0;
            }
        }
        //都不符合，还原地图
        map[i][j] = 0;
        return false;
    }
}
