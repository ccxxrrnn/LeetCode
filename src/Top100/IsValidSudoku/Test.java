package Top100.IsValidSudoku;

/**
 * @Author xiongwei
 * @WriteTime 2020-10-27 11:06
 */

/**
 *判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 */

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public boolean isValidSudoku(char[][] board) {
        //同一行，同一列，同一九宫格只能出现1~9
        int[][] row=new int[9][10];  //行
        int[][] clo=new int[9][10];  //列
        int[][] box=new int[9][10];  //九宫格
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j]=='.') continue;
                int t=board[i][j]-'0';
                if (row[i][t]==1) return false;
                if (clo[j][t]==1) return false;
                if(box[i/3+(j/3)*3][t]==1) return false;
                row[i][t]=1;
                clo[j][t]=1;
                box[i/3+(j/3)*3][t]=1;
            }
        }
        return true;
    }
}
