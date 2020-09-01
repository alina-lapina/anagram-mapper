package home.anagrammapper;

import java.util.Arrays;

public class AnagramHashFunction {

    public static String hashString(String text) {
        char charArray[] = text.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
