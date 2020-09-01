package home.anagrammapper;

import java.util.Arrays;

public class AnagramHashFunction {

    public static String hashString(String text) {
        if (text == null) return "";

        char[] charArray = text.toLowerCase().replaceAll("[ ]", "").toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
