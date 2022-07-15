package triesandpatternmatching;

import triesandpatternmatching.ds.Node;
import triesandpatternmatching.ds.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Little cute kitten loves to write stories in a Github README document. One day she is
 * given a list of words, you want to help her to check if each of these words are present in
 * the README file
 *
 * Input:
 *
 * document = "little cute cat loves to code in c++, java & python"
 * words = ["cute cat", "ttle", "cutest", "cat", "quick","big"]
 *
 * Sample Output:
 *
 * yes, yes, yes, no, no
 */
public class CuteLittleCat {
    public static void main(String[] args) {
        cuteLittleCat("little cute cat loves to code in c++, java & python", new String[]{"cute cat", "ttle", "cat", "quick", "big"});
    }

    private static void cuteLittleCat(String d, String[] words) {
        //1. Create a trie of words to search
        Trie t = new Trie();
        for (String s : words)
            t.insert(s);

        //2. Search substring in the document to check if the match with any of the word inserted in Trie
        Map<String, Boolean> m = new HashMap<>();
        for (int i = 0; i < d.length(); i++) {
            searchHelper(t, d, i, m);
        }

        //3. You can check if any of the words are present in the hashmap.
        for (String s : words) {
            System.out.print(m.containsKey(s) + " ");
        }
    }

    private static void searchHelper(Trie t, String d, int i, Map<String, Boolean> map) {
        Node temp = t.root;
        for (int j = i; j < d.length(); j++) {
            char ch = d.charAt(j);
            if (!temp.children.containsKey(ch))
                return;
            temp = temp.children.get(ch);
            if (temp.isTerminal) {
                String out = d.substring(i, j+1);
                map.put(out, true);
            }
        }
        return;
    }
}
