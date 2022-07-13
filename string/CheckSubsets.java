package string;

/**
 * Given two non-empty strings, write a function that determines whether
 * the second string is a subsequence of the first one.
 *
 * Sample Input:
 *
 * codingminutes
 * cines
 *
 * Sample Output:
 * Yes
 */
public class CheckSubsets {
    public static void main(String[] args) {
        System.out.println(checkSubsets("codingminutes", "cines"));
    }

    private static boolean checkSubsets(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int j = 0;
        int count = 0;
        for (int i = 0; i < s2Arr.length; i++) {
            char c = s2Arr[i];
            while (!(s1Arr[j] == c)) {
                j++;
            }
            if (s1Arr[j] == c)
                count++;
        }

        return count == s2Arr.length;
    }
}
