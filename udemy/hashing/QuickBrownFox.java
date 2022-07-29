package udemy.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Quick Brown Fox:
 *
 * Given a udemy.string without spaces and a list of words. Write a  function that finds the min bars
 * to be added to the udemy.string so that all resulting words in are found in the list.
 *
 * Sample Input:
 *
 * String s = "thequickbrownfox"
 * words = ["the","quickbrown","fox","quick", "brown"]
 */
public class QuickBrownFox {
    public static void main(String[] args) {

        String s = "thequickbrownfox";
        Set<String> set = new HashSet<>();
        set.add("the");
        set.add("quickbrown");
        set.add("fox");
        set.add("quick");
        set.add("brown");
        System.out.println(quickbrownfox(s, 0, set) - 1);
    }

    private static int quickbrownfox(String s, int idx, Set<String> set) {
        if (idx == s.length())
            return 0;

        int ans = Integer.MAX_VALUE;
        String current_string = "";

        for (int i = idx; i < s.length(); i++) {
            current_string += s.charAt(i);
            if (set.contains(current_string)) {
                int remainingAnswer = quickbrownfox(s, i + 1, set);
                if (remainingAnswer != -1) {
                    ans = Math.min(ans, 1 + remainingAnswer);
                }
            }
        }

        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }
}

