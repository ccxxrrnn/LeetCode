package String.DFS.RestoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-24 17:34
 **/

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */
public class Test {

    private List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result=new ArrayList<>();
        if (s.length()<4 || s.length()>12) return result;
        dfs(s,0,0,"");   //i 字符串已经处理的长度  j 字串长度
        return result;
    }

    private void dfs(String s, int i, int j, String str) {
        if (i!=s.length() && j==4){ // 已经分为四份了，但是数据还有剩余 ,或者i已经分完了但是j不满足
            return;
        }
        if(i==s.length()){
            if (j==4) {
                String res=str.substring(0, str.length()-1);
                if (!result.contains(res)) result.add(res);
                return;
            }else{
                return;
            }
        }
        if (s.charAt(i)=='0') {
            dfs(s, i+1, j+1, str+"0.");
        } //假如为0，只能单独作为一个
        else {
            for (int m = 1; m < 4 && i + m <= s.length(); m++) {   //一般情况，最多可以分三个
                String subS = s.substring(i, i + m);
                if (Integer.parseInt(subS) <= 255) {  //如果等于三个就和255作比较
                    dfs(s, i + m, j + 1, str + subS + ".");
                } else { //截取值为大于255 ，不和规则
                    break;
                }
            }
        }

    }
}
