package triesandpatternmatching.ds;

public class Trie {
    Node root;

    public Trie() {
        root = new Node(false);
    }

    public void insert(String s) {
        char[] arr = s.toCharArray();
        Node current = root;

        for (int i = 0; i < arr.length; i++) {
            char l = arr[i];
            int finalI = i;
            current = current.children.computeIfAbsent(l, c -> new Node(finalI == arr.length - 1));
        }
    }

    public boolean search(String s) {
        char[] arr = s.toCharArray();
        Node temp = root;
        for (char ch : arr) {
            if (!temp.children.containsKey(ch))
                return false;
            temp = temp.children.get(ch);
        }
        return temp.isTerminal;
    }
}
