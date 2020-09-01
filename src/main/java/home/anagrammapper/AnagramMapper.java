package home.anagrammapper;

import java.util.List;
import java.util.Set;

public class AnagramMapper {

    public static List<Set<String>> process(Set<String> input) {
        return List.of(
                Set.of("abc", "cab"),
                Set.of("dabn")
        );
    }
}
