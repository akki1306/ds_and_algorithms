package udemy.arrays;

import java.util.*;

public class MinimumArraysToBurstBaloons {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
    }


    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int cntArrows = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++) {
            if(points[i][0] > end) {
                cntArrows++;
                end = points[i][1];
            }
        }
        return cntArrows;
    }
}
