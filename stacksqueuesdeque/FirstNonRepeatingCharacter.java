package stacksqueuesdeque;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * First Non Repeating Character
 *
 * You are given a running stream of characters, output the first
 * non repeating character in the string formed so far after every
 * new character you get in input. Output -1 if such a character
 * doesnt exists.
 *
 * Input
 *
 * a a b c c b c d
 *
 * Output
 *
 * a -1 b b b -1 -1 d
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabccbcd";
        System.out.println(firstNonRepeatingCharacter(s));
    }

    private static List<Character> firstNonRepeatingCharacter(String s) {
        Queue<Character> queue = new LinkedBlockingDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        List<Character> result = new ArrayList<>();

        char[] c = s.toCharArray();

        for (char ch : c) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            queue.add(ch);

            while (!queue.isEmpty()) {
                if (map.get(queue.peek()) == 1) {
                    result.add(queue.peek());
                    break;
                } else {
                    queue.poll();
                }
            }
            if (queue.isEmpty())
                result.add('1');
        }
        return result;
    }
}
