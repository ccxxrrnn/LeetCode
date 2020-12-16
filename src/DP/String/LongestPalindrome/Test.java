package DP.String.LongestPalindrome;


/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 19:49
 **/

//5. 最长回文子串
//动态规划
//中心扩展
public class Test {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int lenS = s.length();
        boolean[][] dp = new boolean[lenS + 1][lenS + 1];
        String res = "";
        for (int l = 0 ; l < chars.length ; l++){
            for (int i = 0; i < chars.length - l; i++){
                if (l == 0){
                    dp[l][i] =true;
                }else if (l == 1){
                    dp[l][i] = chars[i] == chars[i + 1];
                }else{
                    dp[l][i] = dp[l - 2][i + 1] && chars[i] == chars[i + l];
                }
                if (dp[l][i] && (l + 1 > res.length())){
                    res = s.substring(i , i + l + 1);
                }
            }
        }
        return res;
    }

//    public String longestPalindrome(String s) {
//        if (s.length()<1) return "";
//        ArrayList<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
//        int maxLength=1;
//        String result = sList.get(0);
//        for (int i=0;i<sList.size()-maxLength+1;i++){
//            for (int j=i+1;j<sList.size();j++){
//                if ((j-i+1)>maxLength && validPalindromic(sList,i,j)){
//                        maxLength=j-i+1;
//                        result=s.substring(i,j+1);
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean validPalindromic(ArrayList<String> sList, int i, int j) {
//        while(i<j){
//            if (!sList.get(i).equals(sList.get(j))){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
}
