package home;

import home.anagrammapper.AnagramMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Anagrams
{
    public static void main( String[] args )
    {
        System.out.println( "---------------------------------" );
        System.out.println( "|        Anagram Mapper         |" );
        System.out.println( "---------------------------------" );

        if (args.length != 1) {
            System.out.printf("%nUsage: Provide a path to a text file with words.%n%n");
            System.exit(1);
        }

        try {

            List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
            System.out.printf("%nFile %s read successfully.%n%n", args[0]);

            System.out.println(
                    handleOutput(AnagramMapper.process(new HashSet<>(lines)))
            );

        } catch (java.nio.file.NoSuchFileException e) {

            System.out.printf("%nFile does not exist %s.%n", args[0]);

        } catch (IOException e) {

            System.out.printf("%nCannot read file %s.%n", args[0]);
            e.printStackTrace();

        }
    }

    public static String handleOutput(List<Set<String>> result)
    {
        List<Set<String>> filtered = result.stream()
                .filter(v -> v.size() > 1).collect(Collectors.toList());

        return filtered.isEmpty()
                ? "No anagrams in the list."
                : filtered.stream().map(l -> String.format("%n %s", l.toString().replaceAll("[\\[|\\],]", "")))
                .collect(Collectors.joining());
    }
}
