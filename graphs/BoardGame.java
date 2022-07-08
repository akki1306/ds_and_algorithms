package graphs;

import java.util.*;

public class BoardGame {
    public static void main(String[] args) {
       List<String> words = Arrays.asList("SNAKE", "FOR", "QUEZ", "SNACK", "SNACKS", "GO", "TUNES", "CAT");

        char[][] board = new char[][]{
                {'S', 'E', 'R', 'T'},
                {'U', 'N', 'K', 'S'},
                {'T', 'C', 'A', 'T'}
        };

        System.out.println(boardGame(board, words));
    }

    private static void searchWords(Trie t, Node root, char[][] board, boolean[][] visited, int x, int y, int m, int n, Set<String> output) {
        char ch = board[x][y];

        if (!root.children.containsKey(ch))
            return;

        visited[x][y] = true;
        root = root.children.get(ch);

        if (root.isTerminal) {
            output.add(root.word);
        }

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < m && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
                searchWords(t, root, board, visited, nx, ny, m, n, output);
            }
        }

        visited[x][y] = false;
        return;
    }

    private static Set<String> boardGame(char[][] board, List<String> words) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> output = new HashSet<>();
        Trie t = new Trie();

        for (String s : words)
            t.insert(s);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                searchWords(t, t.root, board, visited, i, j, m, n, output);
            }
        }

        return output;
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node('\n', false, null);
        }

        public void insert(String s) {
            Node temp = root;
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                char key = c[i];
                boolean isTerminal = i == c.length - 1;
                if (!temp.children.containsKey(key)) {
                    Node n = new Node(key, isTerminal, isTerminal ? s : null);
                    temp.children.put(key, n);
                }
                temp = temp.children.get(key);
            }
        }

        public boolean canMoveTo(Node node, char c) {
            return node.children.containsKey(c);
        }

        public boolean isTerminal(Node node) {
            return node.isTerminal;
        }

        public String getWord(Node node) {
            return node.word;
        }
    }

    static class Node {
        public Map<Character, Node> children;
        public boolean isTerminal;
        public char c;
        public String word;

        public Node(char c, boolean isTerminal, String word) {
            this.c = c;
            this.isTerminal = isTerminal;
            this.children = new HashMap<>();
            this.word = word;
        }
    }
}
