package leetcode.strings;

// Leetcode 424
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("BBBBAAACAC", 1));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
        int[] arr = new int[26];
        int freqCharCount = Integer.MIN_VALUE;
        while (right < s.length()) {
            arr[s.charAt(right) - 'A']++;
            freqCharCount = Math.max(freqCharCount, arr[s.charAt(right) - 'A']);
            //contract left
            if (right - left + 1 - freqCharCount > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen); // count max len
            right++; // expand right
        }
        return maxLen;
    }
}
