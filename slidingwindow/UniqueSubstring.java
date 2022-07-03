package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueSubstring {
    public static void main(String[] args) {
//        System.out.println(largestSubstringUniqueCharacters("prateekbhaiya"));
        System.out.println(uniqueSubstring(("prateekbhaiya")));
    }

    private static String largestSubstringUniqueCharacters(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] res = new int[2];
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();

        int maxWindow = Integer.MIN_VALUE;
        int windowLen = 0;
        while (j < n && i <= j) {
            int index = map.getOrDefault(c[j], -1);
            if (index < 0) {
                map.put(c[j], j);
                windowLen++;
                if (maxWindow < windowLen) {
                    res[0] = i;
                    res[1] = j;
                }
                maxWindow = Math.max(maxWindow, windowLen);
            } else {
                int lastIndex = map.get(c[j]);
                while (lastIndex != -1 && i < lastIndex) {
                    map.put(c[i], -1);
                    i++;
                    windowLen--;
                }
                if (i == lastIndex) {
                    map.put(c[i++], j);
                }
            }
            j++;
        }
        return s.substring(res[0], res[1] + 1);
    }

    // using array
    // time complexity - O(N)
    // space complexity - O(1)
    private static String uniqueSubstring(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = 0, n = c.length;
        int[] map = new int[200];
        Arrays.fill(map, -1);
        int windowLen = 0;
        int start = 0;
        int maxWindowLen = Integer.MIN_VALUE;
        while (j < n) {
            if (map[c[j]] != -1 && map[c[j]] >= i) {
                i = map[c[j]] + 1;
                windowLen = j - i;
            }

            map[c[j]] = j;
            windowLen++;
            j++;

            if (windowLen > maxWindowLen) {
                maxWindowLen = windowLen;
                start = i;
            }
        }
        return s.substring(start, start+ maxWindowLen);
    }

    private static String uniqueString(String s) {
        char[] c = s.toCharArray();
        int window_len = 0;
        int max_window = 0;
        int start_window = 0;
        int i = 0, j = 0;
        int n = s.length();
        Map<Character, Integer> m = new HashMap<>();

        while (j < n) {
            char ch = s.charAt(j);

            if (m.containsKey(ch) && m.get(ch) >= i) {
                i = m.get(ch) + 1;
                window_len = j - i;
            }

            m.put(ch, j);
            window_len++;
            j++;

            if (window_len > max_window) {
                max_window = window_len;
                start_window = i;
            }
        }
        return s.substring(start_window, max_window);
    }
}
