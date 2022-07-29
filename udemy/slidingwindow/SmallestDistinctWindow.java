package udemy.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a udemy.string, find the smallest window which contains all distinct characters of a given
 * input udemy.string.
 * <p>
 * Sample inputs:
 * <p>
 * aabcbcdbcaaab
 * aaaa
 * <p>
 * Sample outputs:
 * <p>
 * dbca
 * a
 */
public class SmallestDistinctWindow {
    public static void main(String[] args) {
        System.out.println(smallestDistinctWindow("aabcbcdbcaaad"));
    }

    private static String smallestDistinctWindow(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int i = 0;
        int windowLen = 0;
        int minValue = Integer.MAX_VALUE;

        Set<Character> set = new HashSet<>();
        int distinctCnt = 0;
        for (char ch : c)
            if (set.add(ch))
                distinctCnt++;

        int[] map = new int[256];
        int cnt = 0;
        int startIdx = -1;
        for (int j = 0; j < n; j++) {
            // expand window to right
            map[c[j]]++;

            // if any distinct character matched then increment count
            if (map[c[j]] == 1)
                cnt++;

            // contract from left
            if (cnt == distinctCnt) {
                while (map[c[i]] > 1) {
                    if (map[c[i]] > 1)
                        map[c[i]]--;
                    i++;
                }

                // update max
                windowLen = j - i + 1;
                if (minValue > windowLen) {
                    minValue = windowLen;
                    startIdx = i;
                }
            }

        }
        return s.substring(startIdx, startIdx + minValue);
    }
}
