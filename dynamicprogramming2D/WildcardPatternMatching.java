package dynamicprogramming2D;

/**
 * Wildcard pattern matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching
 * algorithm that finds if wildcard pattern is matched with input string.
 *
 * The wildcard pattern can include the characters '?' and '*':
 *
 * '?' matches any single character
 * '*' matches any sequence of characters (including the empty sequence)
 * The matching should cover entire input string (not partial)
 *
 * For example:
 *
 * Text = "baaabab"
 * Pattern = "**ba**ab", output: true
 * Pattern = baaa?ab, output: true
 * Pattern = ba*a?, output: true
 * Pattern = a*ab, output: false
 */
public class WildcardPatternMatching {
    public static void main(String[] args) {
        System.out.println(wildcardPatternMatching("**ba**ab", "baaabab", 0, 0));
        System.out.println(wildcardPatternMatching("**b**", "baaabab", 0, 0));
        System.out.println(wildcardPatternMatching("*", "baaabab", 0, 0));
        System.out.println(wildcardPatternMatching("baaa?ab", "baaabab", 0, 0));
        System.out.println(wildcardPatternMatching("a*ab", "baaabab", 0, 0));

    }

    private static boolean wildcardPatternMatching(String pattern, String s, int i, int j) {
        if (i >= pattern.length() && j >= s.length())
            return true;

        if (i >= pattern.length())
            return false;

        if (j >= s.length()) {
            while (i < pattern.length()) {
                if(pattern.charAt(i)!='*')
                    return false;
                i++;
            }
            return true;
        }

        if ((i >= pattern.length() && j < s.length()) || (i < pattern.length() && j >= s.length()))
            return false;

        char pc = pattern.charAt(i);
        char sc = s.charAt(j);
        if (pc == '*')
            return wildcardPatternMatching(pattern, s, i + 1, j) || wildcardPatternMatching(pattern, s, i, j + 1);
        else if (pc == '?' || pc == sc)
            return wildcardPatternMatching(pattern, s, i + 1, j + 1);
        else
            return false;
    }
}
