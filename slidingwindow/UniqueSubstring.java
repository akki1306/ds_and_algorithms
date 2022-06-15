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
        int end = 0;
        int maxWindowLen = Integer.MIN_VALUE;
        while (j < n) {
            if (map[c[j]] != -1) {
                while (i <= map[c[j]]) {
                    i++;
                    windowLen--;
                }
                map[c[j]] = -1;
            } else {
                map[c[j]] = j;
                windowLen++;
            }

            if (windowLen > maxWindowLen) {
                maxWindowLen = windowLen;
                start = i;
                end = j;
            }
            j++;
        }
        return s.substring(start, end);
    }
}
