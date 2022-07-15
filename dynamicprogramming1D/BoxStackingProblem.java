package dynamicprogramming1D;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Box Stacking Problem
 *
 * We are given an array of boxes. Each box is represented using 3 integers denoting
 * height, width, depth of the box. Our goal is stack up the boxes and maximize the total
 * height of the stack.
 *
 * You cant rotate any box i.e. integers in each box must represent [width, height, depth]
 * at all times.
 *
 * A box must have strictly smaller width, depth, and height than any other box below it.
 *
 * Input:
 *
 * Boxes=[
 * [2,1,2],
 * [3,2,3],
 * [2,2,8],
 * [2,3,4],
 * [2,2,1],
 * [4,4,5]
 * ]
 *
 * Output:
 *
 * 10
 *
 * Explanation: We can stack 3 boxes to get height 10.
 *
 * [2,1,2]
 * [3,2,3]
 * [4,4,5]
 */
public class BoxStackingProblem {
    public static void main(String[] args) {
        Box[] boxArr = {
                new Box(2, 1, 2),
                new Box(3, 2, 3),
                new Box(2, 2, 8),
                new Box(2, 3, 4),
                new Box(2, 2, 1),
                new Box(4, 4, 5)
        };
        System.out.println(boxHeightDp(boxArr));
        //Arrays.sort(boxArr, new BoxHeightComparator());
        //System.out.println(boxHeightRecursion(boxArr, boxArr.length - 1));
    }

    private static int boxHeightDp(Box[] boxArr) {
        Arrays.sort(boxArr, new BoxHeightComparator());

        int[] dp = new int[boxArr.length];
        dp[0] = boxArr[0].height;
        for (int i = 1; i < boxArr.length; i++) {
            int maxHeight = 0;
            for (int j = 0; j < i; j++) {
                if (canPlace(boxArr, i, j))
                    maxHeight = Math.max(boxArr[i].height + dp[j], maxHeight);
                else
                    maxHeight = Math.max(boxArr[i].height, maxHeight);
            }
            dp[i] = Math.max(maxHeight, dp[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);
        return max;
    }

    private static boolean canPlace(Box[] boxArr, int i, int j) {
        return boxArr[j].width < boxArr[i].width && boxArr[j].depth < boxArr[i].depth && boxArr[j].height < boxArr[i].height;
    }

/*
    private static int boxHeightRecursion(Box[] boxArr, int index) {
        if (index == 0)
            return boxArr[0].height;
        int maxHeight = 0;
        for (int i = 0; i < index; i++) {
            if (boxArr[i].width < boxArr[index].width && boxArr[i].depth < boxArr[index].depth)
                maxHeight = Math.max(boxArr[index].height + boxHeightRecursion(boxArr, i), maxHeight);
            else
                maxHeight = Math.max(boxArr[index].height, maxHeight);
        }
        return maxHeight;
    }
*/

    static class Box {
        public int width;
        public int depth;
        public int height;

        public Box(int width, int depth, int height) {
            this.width = width;
            this.depth = depth;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box box = (Box) o;
            return width == box.width && depth == box.depth && height == box.height;
        }

        @Override
        public int hashCode() {
            return Objects.hash(width, depth, height);
        }
    }

    static class BoxHeightComparator implements Comparator<Box> {
        @Override
        public int compare(Box o1, Box o2) {
            return Integer.compare(o1.height, o2.height);
        }
    }
}
