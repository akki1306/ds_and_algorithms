package stacksqueuesdeque;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabcbcd";
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
                result.add('0');
        }
        return result;
    }
}
