/**
 * Created by GrasFish on 2017/9/16.
 */

import java.util.regex.*;

public class OtherTest {
    public static void main(String[] args) {
        String string = "12.5+6.7296-0.218";
        Pattern pattern = Pattern.compile("([\\d]*[.][\\d]*)+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
