package arrays;

import java.util.Arrays;

/**
 * Implement a function that takes a vector of integers, and returns a vector of the same length,
 * where each element of the array is equal to the product of every number in the input array.
 * Solve this problem without using division.
 *
 * In other words, the value at output[i] is equal to the product of every number in the input
 * array other that input[i]. You can assum that answer can be stored inside int datatype
 * and no overflow will occur due to products.
 *
 * Sample Input:
 *
 * Input:
 * {1,2,3,4,5}
 *
 * Output:
 * {120,60,40,30,24}
 */
public class ArrayProducts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayProductQuadratic(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(arrayProductLinear(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(arrayProductLinearTimeSpaceConstant(new int[]{1, 2, 3, 4, 5})));
    }

    // time complexity - O(n2)
    // space complexity - O(N)
    private static int[] arrayProductQuadratic(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res, 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j)
                    res[i] *= arr[j];
            }
        }
        return res;
    }

    // time complexity - O(N)
    // space complexity - O(N)
    private static int[] arrayProductLinear(int[] arr) {
        int n = arr.length;

        int[] leftPrefix = new int[arr.length];
        int[] rightSuffix = new int[arr.length];
        int[] result = new int[arr.length];

        leftPrefix[0] = 1;
        rightSuffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            leftPrefix[i] = leftPrefix[i - 1] * arr[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightSuffix[i] = rightSuffix[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = leftPrefix[i] * rightSuffix[i];
        }

        return result;
    }

    // time complexity - O(N)
    // space complexity - O(1)
    private static int[] arrayProductLinearTimeSpaceConstant(int[] array) {
        int len = array.length;
        int[] ans = new int[len];

        //Find left product
        ans[0] = 1;
        for (int i = 1; i < array.length; i++) {
            ans[i] = ans[i - 1] * array[i - 1];
        }

        // find right product
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * array[i];
        }

        return ans;
    }
}
