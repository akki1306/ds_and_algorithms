package leetcode.strings;

// Leetcode 392
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdcb"));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length();
        int n = t.length();

        while (i < m && j < n) {
            int sCh = s.charAt(i);
            int tCh = t.charAt(j);

            if (sCh == tCh) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i >= s.length();
    }
}
