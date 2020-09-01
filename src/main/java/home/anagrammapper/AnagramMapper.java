package home.anagrammapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;


public class AnagramMapper {

    public static List<Set<String>> process(Set<String> input) {
        Map<String, Set<String>> result = input.stream().collect(groupingBy(AnagramHashFunction::hashString, toSet()));
        return new ArrayList<>(result.values());
    }
}
