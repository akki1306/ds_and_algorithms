package udemy.binarytrees;

import udemy.binarytrees.ds.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderPrint {
    public static void main(String[] args) {
        Node root = BuildLevelOrder.buildLevelOrder(new int[]{1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, 8, -1, 9});
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrderPrint(root, map, 0);
        System.out.println(map);
    }

    private static void verticalOrderPrint(Node root, Map<Integer, List<Integer>> verticalOrder, int level) {
        if (root == null)
            return;

        List<Integer> levelList = verticalOrder.getOrDefault(level, new ArrayList<>());
        levelList.add(root.val);
        verticalOrder.put(level, levelList);

        verticalOrderPrint(root.left, verticalOrder, level - 1);
        verticalOrderPrint(root.right, verticalOrder, level + 1);
    }
}
