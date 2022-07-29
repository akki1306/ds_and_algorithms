package udemy.sortingsearching;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a list of n strings a1,a2,...an. You'd like to concatenate
 * them together in some order such that the resulting udemy.string would be
 * lexicographically smallest.
 *
 * Given the list of strings, output the lexicographically smallest
 * concatenation.
 */
public class SmallestString {
    public static void main(String[] args) {
        System.out.println(smallestString(Arrays.asList("c","cb","cba")));
    }

    private static String smallestString(List<String> input) {
        Collections.sort(input, new LexicographicSort());
        return input.stream().collect(Collectors.joining());
    }

    static class LexicographicSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

}

