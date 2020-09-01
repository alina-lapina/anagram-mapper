package home.anagrammapper;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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

}
