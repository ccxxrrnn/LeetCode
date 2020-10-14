package Top100.LongestPalindrome;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 19:49
 **/
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String input="bzxcb";
        String out=t.longestPalindrome(input);
        System.out.println(out);
    }
    public String longestPalindrome(String s) {
        if (s.length()<1) return "";
        ArrayList<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
        int maxLength=1;
        String result = sList.get(0);
        for (int i=0;i<sList.size()-maxLength+1;i++){
            for (int j=i+1;j<sList.size();j++){
                if ((j-i+1)>maxLength && validPalindromic(sList,i,j)){
                        maxLength=j-i+1;
                        result=s.substring(i,j+1);
                }
            }
        }
        return result;
    }

    private boolean validPalindromic(ArrayList<String> sList, int i, int j) {
        while(i<j){
            if (!sList.get(i).equals(sList.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
