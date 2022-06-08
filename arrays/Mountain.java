package arrays;

public class Mountain {
    public static void main(String[] args) {
        int[] input = new int[]{5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        System.out.println(lengthOfHighestMountain(input));
    }

    private static int lengthOfHighestMountain(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; ) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int count = 1;
                int k = i;
                while (k > 0 && arr[k] > arr[k - 1]) {
                    count++;
                    k--;
                }

                while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                    count++;
                    i++;
                }

                max = Math.max(max, count);
            } else {
                i++;
            }
        }
        return max;
    }
}
