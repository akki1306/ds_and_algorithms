package leetcode.strings;

// Leetcode 409
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaggccggcgcgcgcgwiuqwoeuqwoeuoqwewqwqe"));
    }

    public static int longestPalindrome(String s) {
        int[] map = new int[256];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }


        int cnt = 0;

        for (int i = 0; i < 256; i++) {
            if(cnt%2!=0 && map[i]%2!=0)
                cnt += map[i] - 1;
            else
                cnt += map[i];
        }
        return cnt;
    }
}
