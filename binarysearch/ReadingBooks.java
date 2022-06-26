package binarysearch;

import java.util.Arrays;

public class ReadingBooks {
    public static void main(String[] args) {
        System.out.println(readingBooksMinimizeMaximum(new int[]{10, 20, 30, 40}, 2));
    }

    private static int readingBooksMinimizeMaximum(int[] arr, int numStudents) {
        int s = arr[0];
        int e = Arrays.stream(arr).sum();
        int mid, ans = Integer.MAX_VALUE;
        while (s <= e) {
            mid = (s + e) / 2;
            if (canAllocateOptimally(arr, numStudents, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canAllocateOptimally(int[] arr, int numStudents, int maxPages) {
        int current_student = 0;
        int students = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxPages) {
                return false;
            }

            if (current_student + arr[i] > maxPages) {
                students++;
                current_student = arr[i];
            } else {
                current_student += arr[i];
            }
        }
        return students == numStudents;
    }
}
