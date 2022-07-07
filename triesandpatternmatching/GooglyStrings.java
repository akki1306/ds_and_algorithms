package triesandpatternmatching;

import triesandpatternmatching.ds.Node;
import triesandpatternmatching.ds.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
