package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        String string = "ABCD";
        Combination c = new Combination();
        c.combo("", string);
    }

    private void combo(String prefix, String body) {
        System.out.print(String.format("combo(%s, %s); \t\t", prefix, body));
        if (body.length() > 0) {
            char headOfBody = body.charAt(0);
            System.out.println(prefix + headOfBody + "\t");
            String newPrefix = prefix + body.charAt(0);
            String newBody = body.substring(1);
            combo(newPrefix, newBody);
            combo(prefix, newBody);
        }
    }

}
