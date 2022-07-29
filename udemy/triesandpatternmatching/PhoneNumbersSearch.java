package udemy.triesandpatternmatching;

import udemy.triesandpatternmatching.ds.Node;
import udemy.triesandpatternmatching.ds.Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneNumbersSearch {
    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(filterNames("257429", Arrays.asList("prateek","akshay")));
    }

    private static void validWords(Node root, String num, int i, Set<String> output) {
        if (root.isTerminal)
            output.add(root.word);

        if (i == num.length())
            return;

        int digit = num.charAt(i) - '0';

        for (int j = 0; j < keypad[digit].length(); j++) {
            if (root.children.containsKey(keypad[digit].charAt(j))) {
                validWords(root.children.get(keypad[digit].charAt(j)), num, i + 1, output);
            }
        }
        return;
    }

    private static Set<String> filterNames(String phoneNumber, List<String> words) {
        Trie t = new Trie();
        // insert valid words
        for (String s : words)
            t.insert(s);

        Set<String> output = new HashSet<>();
        validWords(t.root, phoneNumber, 0, output);
        return output;
    }
}
