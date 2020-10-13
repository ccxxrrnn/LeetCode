package TestIsMatch;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-13 16:40
 **/
public class Test {
    public static void main(String[] args) {
     Test test=new Test();
     Boolean b =test.isMatch("aaa","a*aaaaaaa");
        System.out.println(b);
    }
    public boolean isMatch(String s, String p){
        int m=s.length();
        int n=p.length();
        boolean[][] f= new boolean[m + 1][n + 1];
        for (int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                //空正则
                if (j==0){
                    f[i][j]=i==0;
                }
                else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[m][n];
    }
}
