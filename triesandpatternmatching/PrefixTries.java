package triesandpatternmatching;

import triesandpatternmatching.ds.Trie;

import java.util.Arrays;

public class PrefixTries {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        t.insert("ape");
        t.insert("mango");
        t.insert("news");
        t.insert("no");
        System.out.println(Arrays.toString(query(t, new String[]{"apple", "banana", "new", "mango"})));
    }

    private static boolean[] query(Trie t, String[] queries) {
        boolean[] res = new boolean[queries.length];
        int i = 0;
        for (String s : queries) {
            res[i++] = t.search(s);
        }
        return res;
    }
}
