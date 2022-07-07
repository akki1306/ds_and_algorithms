package triesandpatternmatching;

import triesandpatternmatching.ds.Node;
import triesandpatternmatching.ds.Trie;

public class BiggestXOR {
    public static void main(String[] args) {
        biggestXOR(new int[]{3, 10, 5, 8, 2, 25});
    }

    private static void biggestXOR(int[] arr) {
        Trie t = new Trie();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            String prevNum = String.format("%08d", Integer.valueOf(Integer.toBinaryString(arr[i - 1])));
            String currNum = String.format("%08d", Integer.valueOf(Integer.toBinaryString(arr[i])));
            t.insert(prevNum);
            max = Math.max(Integer.parseInt(searchMaximum(t, currNum), 2) ^ arr[i], max);
        }
        System.out.println(max);
    }

    private static String searchMaximum(Trie t, String numBinary) {
        char[] bts = numBinary.toCharArray();
        Node temp = t.root;
        String s = "";
        char c;
        for (char ch : bts) {
            if (ch == '1' && temp.children.containsKey('0')) {
                c = '0';
                temp = temp.children.get('0');
            } else if (ch == '0' && temp.children.containsKey('1')) {
                c = '1';
                temp = temp.children.get('1');
            } else {
                c = ch;
                temp = temp.children.get(ch);
            }
            s += c;
        }
        return s;
    }
}
