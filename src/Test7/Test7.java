package Test7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-12 10:58
 **/
public class Test7 {

    public static void main(String[] args) {
        Test7 test7=new Test7();
        char[][] chars=new char[][]{
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};
        String word= "abcecba";
        System.out.println( test7.exist(chars,word));
    }

    public boolean exist(char[][] board, String word)  {
        char[] chars=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(board,chars,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int index) {
        if (i>board.length-1 ||
                j>board[0].length-1 || i<0 || j<0  ||
                board[i][j]!=chars[index]){
            return false;
        }
        if (index == chars.length - 1) {
            return true;
        }
        char c=board[i][j];
        board[i][j]=' ';
        boolean flag=dfs(board,chars,i+1,j,index+1) || dfs(board,chars,i,j+1,index+1)
        ||dfs(board,chars,i-1,j,index+1)||dfs(board,chars,i,j-1,index+1);
        board[i][j]=c;
        return flag;
    }


}
