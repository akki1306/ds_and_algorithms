package triesandpatternmatching;

import triesandpatternmatching.ds.Node;
import triesandpatternmatching.ds.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prateek Bhaiya while working at Google often encounters string problems, so this time he is asking for your
 * help to solve this problem. You are given a list of non-empty strings and you have to return a list of all
 * "Googly" strings found in the input list.
 *
 * A string is said to be Googly if it is exactly made up of atleast two instances of other string in the input
 * list of strings.
 *
 * In order for a string to be googly, just containing two instances of other string isnt sufficient, the string be
 * exactly made up of those strings. For example, in this list ["a", "b", "abc"] the string "abc" isnt googly, even
 * though it contains "a" and "b", but "c" isnt a string in the list.
 *
 * Note that strings can be repeated to form a special string, for example in the list ["a", "aaa"], the string
 * "aaa" is a googly string because it is made up of three repeated instances of "a".
 */
public class GooglyStrings {
    public static void main(String[] args) {
        Trie t = new Trie();
        List<String> res = new ArrayList<>();
        List<String> input = Arrays.asList("goo", "gle", "google", "le", "googly", "ly", "g", "googoole");
        for (String s : input) {
            t.insert(s);
        }

        for (String s : input) {
            if (searchGoogly(t, t.root, s, 0, 0))
                res.add(s);
        }

        System.out.println(res);
    }

    private static boolean searchGoogly(Trie t, Node root, String s, int i, int cnt) {
        // string length reached
        if (i == s.length()) {
            return root.isTerminal && (cnt + 1) >= 2;
        }

        char ch = s.charAt(i);

        // trie finished before string length
        if (!root.children.containsKey(ch))
            return false;

        root = root.children.get(ch);

        if (root.isTerminal) {
            boolean remaining = searchGoogly(t, t.root, s, i + 1, cnt + 1);
            if (remaining)
                return true;
        }
        return searchGoogly(t, root, s, i + 1, cnt);
    }
}
