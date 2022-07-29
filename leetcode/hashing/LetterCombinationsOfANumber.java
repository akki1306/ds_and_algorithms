package leetcode.hashing;

import java.util.*;

public class LetterCombinationsOfANumber {
    static Map<Integer, List<Character>> map = new HashMap();

    static {
        map.put(1, new ArrayList());
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m', 'n','o'));
        map.put(7, Arrays.asList('p','q','r','s'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList();
        letterCombinationsHelper(digits, "", output, 0);
        return output;
    }

    public static void letterCombinationsHelper(String digits, String temp, List<String> output, int index) {
        if(temp.length() == digits.length()) {
            output.add(temp);
            return;
        }

        List<Character> chars= map.get(digits.charAt(index)- '0');
        for(int i=0;i<chars.size(); i++) {
            letterCombinationsHelper(digits, temp + chars.get(i), output, index + 1);
        }
    }
}
