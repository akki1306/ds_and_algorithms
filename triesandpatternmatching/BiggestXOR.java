package triesandpatternmatching;

/**
 * Given an array, find the maximum XOR that you can form by picking two
 * numbers from the array.
 *
 * Input:
 *
 * input[] = {3, 10, 5, 8, 2, 25};
 *
 * Output:
 *
 * 28
 *
 * Explanation:
 *
 * XOR of 5 ^ 25 = 28
 */
public class BiggestXOR {
    public static void main(String[] args) {
        biggestXOR(new int[]{3, 10, 5, 8, 2, 25});
    }

    private static void biggestXOR(int[] arr) {
        Trie t = new Trie();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            t.insert(arr[i - 1]);
            max = Math.max(t.searchMaximum(t, arr[i]), max);
        }
        System.out.println(max);
    }


    private static class Node {
        Node left;
        Node right;
    }

    private static class Trie {
        BiggestXOR.Node root;

        Trie() {
            root = new Node();
        }

        void insert(int s) {
            Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int b = (s >> i) & 1;
                if (b == 0) {
                    if (temp.left == null)
                        temp.left = new Node();
                    temp = temp.left;
                } else {
                    if (temp.right == null)
                        temp.right = new Node();
                    temp = temp.right;
                }
            }
        }

        private static int searchMaximum(Trie t, int numBinary) {
            BiggestXOR.Node temp = t.root;
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                int numBit = (numBinary >> i) & 1;
                if (numBit == 1) {
                    if (temp.left != null) {
                        ans += (1 << i);
                        temp = temp.left;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    if (temp.right != null) {
                        ans += (1 << i);
                        temp = temp.right;
                    } else {
                        temp = temp.left;
                    }
                }
            }
            return ans;
        }
    }
}
