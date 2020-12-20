package Simulation.String.reformatNumber;

/**
 * @Author xiongwei
 * @WriteTime 2020-12-20 10:31
 */

//5629. 重新格式化电话号码
public class Test {

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        char[] chars = number.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char c : chars){
            if (c - '0' < 10 && c - '0' >= 0){
                str.append(c);
            }
        }
        char[] newC = str.toString().toCharArray();
        int index = 0;
        int lenC = newC.length;
        while (index < lenC){
            if (lenC - index  == 4){
                sb.append(newC[index]).append(newC[index + 1]).append("-")
                        .append(newC[index + 2]).append(newC[index + 3]);
                sb.append("-");
                break;
            }
            int num = 0;
            while (index < lenC && num < 3){
                sb.append(newC[index]);
                index++;
                num++;
            }
//            System.out.println(index);
            sb.append("-");
        }
        return sb.toString().substring(0,sb.length() - 1);
    }
}
