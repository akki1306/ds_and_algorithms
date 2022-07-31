package geeksforgeeks.sortingandsearching;

public class KthElementOfRowColWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {15, 25, 31, 43},
                {16, 27, 36, 45},
                {28, 30, 39, 49},
                {33, 35, 40, 50},
        };

        System.out.println(kthSmallest(mat, mat.length, 3));
    }

    public static int kthSmallest(int[][]mat,int n,int k)
    {
        if(k==0 || k > n*n || n == 0)
            return -1;

        if(k==1)
            return mat[0][0];

        int low = mat[0][0];
        int high = mat[n-1][n-1];

        while(low < high) {
            int mid = low + (high - low) / 2;

            int cnt = 0;
            int j = n-1;
            for(int i=0;i<n;i++) {
                while(j>=0 && mat[i][j]>mid)
                    j--;
                cnt += j + 1;
            }

            if(cnt < k)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}
