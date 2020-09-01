package home;

import home.anagrammapper.AnagramMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "---------------------------------" );
        System.out.println( "|        Anagram Mapper         |" );
        System.out.println( "---------------------------------" );

        try {

            List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
            System.out.printf("%nFile %s read successfully.%n%n", args[0]);

            List<Set<String>> result = AnagramMapper.process(new HashSet<>(lines));
            result.stream().filter(v -> v.size() > 1).forEach(l ->
                    System.out.println(l.toString().replaceAll("[\\[|\\],]", ""))
            );

        } catch (IOException e) {

            System.out.printf("%nCannot read file %s.%n", args[0]);
            e.printStackTrace();
        }
    }
}
