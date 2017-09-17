/**
 * Created by GrasFish on 2017/9/16.
 */

import java.util.regex.*;

public class OtherTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\+");
        String[] arr = pattern.split("10x^8+5x^-6+-9x^8+0x^5+10x^-6+-100.5x^-9");
        for (String item : arr) {
            System.out.println(item);
            if(Pattern.compile("\\d-").matcher(item).find()) {
                String[] s = Pattern.compile("\\d-").split(item);
                System.out.println(s[0]+s[1]);
                /*Split(s[0]);
                if(s[1].charAt(0) != '0'){
                    Split("-"+s[1]);
                }
                else Split(s[1]);
            }
            else {
                Split(item);
                */
            }
        }
    }

    public static void Split(String s){
        String [] ss = Pattern.compile("[x^]").split(s);
        System.out.print("cof:"+ss[0] + "exp:"+ss[2]);
        System.out.println();
    }
}
