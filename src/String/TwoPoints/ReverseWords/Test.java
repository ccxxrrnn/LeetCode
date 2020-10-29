package String.TwoPoints.ReverseWords;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-24 16:05
 **/

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：" hello world! "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入："a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String s=t.reverseWords("a good   example");
        System.out.println(s);
    }

    //双指针
    public String reverseWords(String s) {
        s=s.trim();
        int end=s.length()-1;
        int left=end;
        StringBuilder sb=new StringBuilder();
        while (left>=0){
            while(left>=0 && s.charAt(left)!=' ') left--; //找到最左边空格
            sb.append(s, left + 1, end + 1).append(" ");
            while(left>=0 && s.charAt(left)==' ') left--; //跳过单词间空格
            end=left;
        }
        return sb.toString().trim();
    }

//    public String reverseWords(String s) {
//        s=s.trim();
//        Stack<String> stack=new Stack<>();
//        for (int i=0,j=0;i<s.length();i++){
//            if (s.charAt(i)==' ' && s.charAt(i-1)==' '){
//                j++;
//                continue;
//            }
//            if (s.charAt(i)==' '){
//                stack.push(s.substring(j,i));
//                j=i+1;
//            }
//            if (i==s.length()-1){
//                stack.push(s.substring(j));
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        while(!stack.isEmpty()){
//            if (stack.size()!=1) {
//                sb.append(stack.pop()).append(" ");
//            }else{
//                sb.append(stack.pop());
//            }
//        }
//        return sb.toString();
//    }
}