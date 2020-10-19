package Sword_Offer.ReplaceSpace;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-11 13:50
 **/
public class Test {
    public static void main(String[] args) {
        Test test =new Test();
//        String s = "We are happy.";
        String s="dasa  ";
        System.out.println(test.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        String[] strings=s.split("");
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1:strings){
            if (s1.equals(" ")){
                s1="%20";
            }
            stringBuffer.append(s1);
        }
        return stringBuffer.toString();
    }
}
