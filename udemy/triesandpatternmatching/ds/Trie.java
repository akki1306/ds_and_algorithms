package udemy.triesandpatternmatching.ds;

public class Trie {
    public Node root;

    public Trie() {
        root = new Node(false);
    }

    public void insert(String s) {
        char[] arr = s.toCharArray();
        Node current = root;

        for (int i = 0; i < arr.length; i++) {
            char l = arr[i];
            int finalI = i;
            Node prev = current;
            current = current.children.computeIfAbsent(l, c -> new Node(finalI == arr.length - 1));
            if (finalI == arr.length - 1) {
                prev.children.get(l).isTerminal = true;
                prev.children.get(l).word = s;
            }
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
