package udemy.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of
 * each bar is 1, compute how much water it can trap after raining.
 *
 */
public class Rains {
    public static void main(String[] args) {
        System.out.println(findAmountOfRainWaterAccumulated(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    // time complexity - O(N)
    // space complexity - O(N)
    private static int findAmountOfRainWaterAccumulated(int[] arr) {
        int[] leftMaxArr = new int[arr.length];
        int[] rightMaxArr = new int[arr.length];

        leftMaxArr[0] = arr[0];
        rightMaxArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i - 1], arr[i]);
            rightMaxArr[arr.length - i - 1] = Math.max(rightMaxArr[arr.length - i], arr[arr.length - i - 1]);
        }

        // below code optimized to one liner on line no. 17

        /*rightMaxArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(arr[i], rightMaxArr[i + 1]);
        }*/

        int amountOfRainWater = 0;
        for (int i = 0; i < arr.length; i++) {
            amountOfRainWater += (Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i]);
        }

        return amountOfRainWater;
    }
}
