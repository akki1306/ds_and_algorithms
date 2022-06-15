package string;

public class PalindromeBreak {
    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
    }

    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[palindrome.length() - 1] = 'b';
        return new String(chars);
    }
}
