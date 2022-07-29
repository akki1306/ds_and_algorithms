package udemy.string;

import java.util.*;

/**
 * Given a list of 'n' strings S0,S1,S2....,Sn-1, each consisting of digits
 * and spaces, the number of spaces is the same for each entry, the goal is to implement a
 * variation of a sort command. None of the strings contains consecutive spaces. Also,
 * no strings starts with a space nor ends with it. Spaces are used to divide strings
 * into columns, which can be used as keys in comparisons.
 */
public class StringKeySort {
    public static void main(String[] args) {
        System.out.println(stringKeySort(Arrays.asList("92 022", "82 12", "77 13"), 2, true, false));
    }

    private static List<String> stringKeySort(List<String> list, int keyColumn, boolean reverse, boolean isNumeric) {
        Comparator<String> c;

        if (isNumeric) {
            c = Comparator.comparing(a -> Integer.valueOf(a));
        } else {
            c = Comparator.comparing(a -> a);
        }

        if (reverse) {
            c = c.reversed();
        }

        Map<String, String> stringToKeyMap = new TreeMap<>(c);
        for (String s : list) {
            String[] split = s.split(" ");
            stringToKeyMap.put(split[keyColumn - 1], s);
        }

        return new ArrayList(stringToKeyMap.values());
    }
}
