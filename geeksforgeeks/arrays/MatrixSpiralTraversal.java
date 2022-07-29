package geeksforgeeks.arrays;

import java.util.ArrayList;

public class MatrixSpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23},
                {24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35}
        };
        System.out.println(spirallyTraverse(matrix, 6, 6));
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> list = new ArrayList();
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        while (top <= bottom && left<=right) {
            for(int i=left; i<=right; i++){
                list.add(matrix[top][i]);
            }

            top++;
            if(top<=bottom && left<=right){
                for(int i=top;i<=bottom;i++){
                    list.add(matrix[i][right]);
                }
            }
            right--;
            if(top<=bottom && left<=right){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if(top<=bottom && left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }
        return list;
    }
}
