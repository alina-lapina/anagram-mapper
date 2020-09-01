package home.anagrammapper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnagramHashFunctionTest {
    @Test
    public void calculateHashCaseInsensitive()
    {
        var input1 = "ghijklmo";
        var input2 = "GHIJKLMO";

        var anagramHash1 = AnagramHashFunction.hashString(input1);
        var anagramHash2 = AnagramHashFunction.hashString(input2);

        assertEquals("Should calculate same hash (case insensitive)", anagramHash1, anagramHash2);
    }

    @Test
    public void calculateHashOrderInsensitive()
    {
        var input1 = "abc";
        var input2 = "cba";

        var anagramHash1 = AnagramHashFunction.hashString(input1);
        var anagramHash2 = AnagramHashFunction.hashString(input2);

        assertEquals("Should calculate same hash for the same set of letters", anagramHash1, anagramHash2);
    }

    @Test
    public void calculateHashOfWordCharactersOnly()
    {
        var input1 = "ab c";
        var input2 = "c-b_a!";

        var anagramHash1 = AnagramHashFunction.hashString(input1);
        var anagramHash2 = AnagramHashFunction.hashString(input2);

        assertEquals("Should calculate hash of word characters only", anagramHash1, anagramHash2);
    }

    @Test
    public void shouldSortLettersAlphabetically()
    {
        var input = "abc";

        var anagramHash = AnagramHashFunction.hashString(input);

        assertEquals("Should sort letters alphabetically", "abc", anagramHash);
    }

    @Test
    public void calculateHashForNorwegianAlphabetLowerCase()
    {
        var input = "abcdefghijklmnopqrstuvwxyzæøå";

        var anagramHash = AnagramHashFunction.hashString(input);

        assertEquals("Should calculate hash for Norwegian alphabet - lower case", "abcdefghijklmnopqrstuvwxyzåæø", anagramHash);
    }

    @Test
    public void calculateHashForNorwegianAlphabetUppercase()
    {
        var input = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

        var anagramHash = AnagramHashFunction.hashString(input);

        assertEquals("Should calculate hash for Norwegian alphabet - upper case", "abcdefghijklmnopqrstuvwxyzåæø", anagramHash);
    }

    @Test
    public void calculateHashRepetitionsSensitive()
    {
        var input = "abAB";

        var anagramHash = AnagramHashFunction.hashString(input);

        assertEquals("Should calculate hash repetitions sensitive", "aabb", anagramHash);
    }

    @Test
    public void zeroHashForEmptyString()
    {
        var input = "";

        var anagramHash = AnagramHashFunction.hashString(input);

        assertEquals("Should calculate zero hash for empty string", "", anagramHash);
    }

    @Test
    public void zeroHashForNull()
    {
        var anagramHash = AnagramHashFunction.hashString(null);

        assertEquals("Should calculate zero hash for empty string", "", anagramHash);
    }
}
