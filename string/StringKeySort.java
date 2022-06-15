package string;

import java.util.*;

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
