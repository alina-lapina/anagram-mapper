package home.anagrammapper;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class AnagramMapperTest {

    @Test
    public void shouldMapAnagrams()
    {
        var input = Set.of("abc", "cab", "dabn");

        var output = AnagramMapper.process(input);

        assertThat("Anagrams are not mapped in the same set",
                output,
                hasItems(
                        Set.of("abc", "cab"),
                        Set.of("dabn"))
        );
    }

    @Test
    public void shouldMapNoAnagrams()
    {
        var input = Set.of("xyz", "klm", "abc");

        var output = AnagramMapper.process(input);

        assertThat("No anagrams should be mapped in single value sets",
                output,
                hasItems(Set.of("xyz"),
                        Set.of("klm"),
                        Set.of("abc"))
        );
    }

    @Test
    public void emptyInput()
    {
        var input = new HashSet<String>();

        var output = AnagramMapper.process(input);

        assertTrue("Empty map expected on empty input", output.isEmpty());
    }
}
