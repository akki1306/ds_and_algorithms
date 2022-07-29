package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

// Leetcode 205
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            sMap.putIfAbsent(sCh, tCh);
            tMap.putIfAbsent(tCh, sCh);
            if (sMap.get(sCh) != tCh || tMap.get(tCh) != sCh)
                return false;
        }

        return true;
    }
}
