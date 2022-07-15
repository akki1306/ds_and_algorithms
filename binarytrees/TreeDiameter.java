package binarytrees;

import binarytrees.ds.Node;
import binarytrees.ds.Tree;

/**
 * Tree Diameter
 *
 * Find the diameter of the tree.
 * Diameter is defined as the largest difference between any two nodes of the binary tree,
 */
public class TreeDiameter {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.buildTree(new int[]{1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1});
        System.out.println(treeDiameter(root));
        HDPair hdPair = new HDPair();
        System.out.println(hdPair.optimizedDiameter(root));
    }

    private static int treeDiameter(Node root) {
        if (root == null)
            return 0;

        int d1 = height(root.left) + height(root.right);
        int d2 = treeDiameter(root.left);
        int d3 = treeDiameter(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }

    private static int height(Node root) {
        if (root == null)
            return 0;

        int h1 = height(root.left);
        int h2 = height(root.right);
        return 1 + Math.max(h1, h2);
    }

    static class HDPair {
        public int height;
        public int diameter;

        public HDPair optimizedDiameter(Node root) {
            HDPair p = new HDPair();
            if (root == null) {
                p.height = p.diameter = 0;
                return p;
            }

            HDPair left = optimizedDiameter(root.left);
            HDPair right = optimizedDiameter(root.right);

            p.height = 1 + Math.max(left.height, right.height);

            int d1 = left.height + right.height;
            int d2 = left.diameter;
            int d3 = right.diameter;


            p.diameter = Math.max(d1, Math.max(d2, d3));
            return p;
        }

        @Override
        public String toString() {
            return "HDPair{" +
                    "height=" + height +
                    ", diameter=" + diameter +
                    '}';
        }
    }
}
