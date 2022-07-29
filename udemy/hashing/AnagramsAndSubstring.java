package udemy.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Anagrams and Substring
 *
 * Two strings are anagrams of each other if the letters of one udemy.string can be rearranged to
 * form the other udemy.string.
 * Given a udemy.string, find the number of pairs of substrings of the udemy.string that are anagrams
 * of each other.
 *
 *
 */
public class AnagramsAndSubstring {
    public static void main(String[] args) {
        String s = "abba";
        Map<String, Integer> map = substrings(s);

        int ans = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() >= 2)
                ans += e.getValue() * (e.getValue() - 1) / 2;
        }
        System.out.println("Count of anagrams is: " + ans);
    }

    private static Map<String, Integer> substrings(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + j <= s.length()) {
                    String ss = getHash(s.substring(i, i + j));
                    map.put(ss, map.getOrDefault(ss, 0) + 1);
                }
            }
        }
        return map;
    }

    private static String getHash(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 97]++;
        }
        String res = "";
        for (int i : arr) {
            res += i;
        }
        return res;
    }
}
