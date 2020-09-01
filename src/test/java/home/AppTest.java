package home;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;
import java.util.Set;

public class AppTest
{
    @Test
    public void testOutput()
    {
        var input = List.of(Set.of("abc", "cab"), Set.of("dabn"));

        var output = Anagrams.handleOutput(input);

        assertTrue("Should only show anagrams",
                output.equals(String.format("%n abc cab"))
                        || output.equals(String.format("%n cab abc"))
        );
    }
}
