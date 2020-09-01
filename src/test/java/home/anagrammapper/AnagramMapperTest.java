package home.anagrammapper;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class AnagramMapperTest {

    @Test
    public void shouldMapAnagrams()
    {
        var input = Set.of("abc", "cab", "dabn");
        var expected = List.of(
                Set.of("abc", "cab"),
                Set.of("dabn")
        );

        var output = AnagramMapper.process(input);

        assertThat("Anagrams are not mapped in the same set", output, is(expected));
    }

    @Test
    public void shouldMapNoAnagrams()
    {
        var input = Set.of("xyz", "klm", "abc");
        var expected = List.of(
                Set.of("xyz"),
                Set.of("klm"),
                Set.of("abc")
        );

        var output = AnagramMapper.process(input);

        assertThat("No anagrams should be mapped in single value sets", output, is(expected));
    }

    @Test
    public void emptyInput()
    {
        var input = new HashSet<String>();

        var output = AnagramMapper.process(input);

        assertEquals("Empty map expected on empty input", 0, output.size());
    }
}
