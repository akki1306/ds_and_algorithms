package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class SmallestDistinctWindow {
    public static void main(String[] args) {
        System.out.println(smallestDistinctWindow("aaaabcdbenccddbb"));
    }

    private static String smallestDistinctWindow(String s) {
        char[] c = s.toCharArray();

        Set<Character> window = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            window.add(c[i]);
        }
        int expectedWindowSize = window.size();
        window.clear();
        int start = 0;
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            boolean isAdded = window.add(ch);
            if (!isAdded) {
                while (!window.add(ch)) {
                    window.remove(c[start++]);
                }
            }
            if (window.size() == expectedWindowSize) {
                return s.substring(start, start + expectedWindowSize);
            }
        }
        return null;
    }
}
