package Top100.MyAtoi;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 11:14
 **/

/**
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String input="20000000000000000000";
        int out=t.myAtoi(input);
        System.out.println(out);
    }
    public int myAtoi(String s) {
        int point=0;
        boolean flag=true;
        if (s.length()<2 && s.matches("[0-9]")){
            return Integer.parseInt(s);
        }
        if (s.length()<2){
            return 0;
        }
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                continue;
            }
            if (s.substring(i, i+1).matches("[0-9]")){
                point=i;
                break;
            }
            boolean b=s.substring(i+1, i+2).matches("[0-9]");
            if(s.charAt(i)=='-' && b){ flag=false;continue;}
            if (s.charAt(i)=='+' && b){continue;}
            return 0;
        }
        String str=s.substring(point);
        int late=str.length();
        for (int j=0;j<str.length();j++){
            if (!str.substring(j, j+1).matches("[0-9]")){
                late=j;
                break;
            }
        }
        String result=str.substring(0,late);
        if (result.length()==0){
            return 0;
        }
        try {
            long longOut = Long.parseLong(result);
            if (!flag) longOut=-longOut;
            if ((int)longOut==longOut){
                return (int)longOut;
            }
            if (longOut>0) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }catch (NumberFormatException e){
            if (flag) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
    }

}
