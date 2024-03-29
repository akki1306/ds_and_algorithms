package udemy.triesandpatternmatching;

import udemy.triesandpatternmatching.ds.Trie;

/**
 * Trie containing all the suffixes of a given udemy.string
 */
public class SuffixTree {
    public static void main(String[] args) {
        Trie t = new Trie();
        buildSuffixTrie(t, "hello");
        System.out.println();
    }

    private static void buildSuffixTrie(Trie t, String s) {
        String temp;
        for (int i = 0; i <= s.length(); i++) {
            temp = s.substring(i);
            t.insert(temp);
        }
    }
}
