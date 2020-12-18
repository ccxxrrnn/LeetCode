package waitwait.IntToRoman;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-20 16:11
 **/


//12. 整数转罗马数字
public class Test {


    public String intToRoman(int num) {
        int[] reg=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] img=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<reg.length;i++){
            while(num>=reg[i]){
                num-=reg[i];
                stringBuilder.append(img[i]);
            }
        }
        return stringBuilder.toString();
    }
}
