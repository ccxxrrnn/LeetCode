package Simulation.String.MyAtoi;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 11:14
 **/


//8. 字符串转换整数 (atoi)
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String input="00000-42a1234";
        int out=t.myAtoi(input);
        System.out.println(out);
    }


    public int myAtoi(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况 如"+-42"
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            // 4.2 合法的情况下，才考虑转换
            res = res * 10 +currChar - '0';
            index++;
        }
        return sign>0?res:sign*res;
    }

//    public int myAtoi(String s) {
//        int point=0;
//        boolean flag=true;
//        if (s.length()<2 && s.matches("[0-9]")){
//            return Integer.parseInt(s);
//        }
//        if (s.length()<2){
//            return 0;
//        }
//        for (int i=0;i<s.length();i++){
//            if (s.charAt(i)==' '){
//                continue;
//            }
//            if (s.substring(i, i+1).matches("[0-9]")){
//                point=i;
//                break;
//            }
//            boolean b=s.substring(i+1, i+2).matches("[0-9]");
//            if(s.charAt(i)=='-' && b){ flag=false;continue;}
//            if (s.charAt(i)=='+' && b){continue;}
//            return 0;
//        }
//        String str=s.substring(point);
//        int late=str.length();
//        for (int j=0;j<str.length();j++){
//            if (!str.substring(j, j+1).matches("[0-9]")){
//                late=j;
//                break;
//            }
//        }
//        String result=str.substring(0,late);
//        if (result.length()==0){
//            return 0;
//        }
//        try {
//            long longOut = Long.parseLong(result);
//            if (!flag) longOut=-longOut;
//            if ((int)longOut==longOut){
//                return (int)longOut;
//            }
//            if (longOut>0) return Integer.MAX_VALUE;
//            return Integer.MIN_VALUE;
//        }catch (NumberFormatException e){
//            if (flag) return Integer.MAX_VALUE;
//            return Integer.MIN_VALUE;
//        }
//    }

}
