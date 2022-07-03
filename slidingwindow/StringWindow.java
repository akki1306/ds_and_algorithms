package slidingwindow;

public class StringWindow {
    public static void main(String[] args) {
        System.out.println(stringWindow("hello", "eo"));
        System.out.println(stringWindow("hello", "elo"));
        System.out.println(stringWindow("fizzbuzz","fuzz"));
    }

    private static String stringWindow(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] c2Map = new int[256];
        int[] c1Map = new int[256];
        int start = 0;
        int startIdx = -1;
        int minSoFar = Integer.MAX_VALUE;
        int windowSize;
        for (int i = 0; i < c2.length; i++) {
            c2Map[c2[i]]++;
        }

        int cnt = 0;
        //sliding window algorithm - expand right and contract left
        for (int i = 0; i < s1.length(); i++) {
            char ch = c1[i];
            // expand the window by including current character
            c1Map[ch]++;
            if (c1Map[ch] != 0 && c1Map[ch] <= c2Map[ch]) {
                cnt++;
            }

            //if all characters of the pattern are found in the current window then start contracting from the left.
            if (cnt == c2.length) { // determining condition for when to contract left
                // start contracting from the left to remove unwated characters
                // unwated characters are either not present in the pattern or the frequency is higher then required.

                while (c2Map[c1[start]] == 0 || c1Map[c1[start]] > c2Map[c1[start]]) {
                    c1Map[c1[start]]--;
                    start++;
                }

                windowSize = i - start + 1;
                if (windowSize < minSoFar) {
                    minSoFar = windowSize;
                    startIdx = start;
                }
            }
        }
        if (startIdx == -1)
            return null;

        return s1.substring(startIdx, startIdx + minSoFar);
    }
}
