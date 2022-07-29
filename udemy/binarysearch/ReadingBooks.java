package udemy.binarysearch;

import java.util.Arrays;

/**
 * Given number of pages in n different books and m students. The books are arranged in any order (not necessarily ascending)
 * of number of pages. Every student is assigned to read some consecutive segment of books. The task is to assign books
 * in such a way that the maximum number of pages assigned to a student is minimum.
 *
 * Find the maximum number of pages that a student will have to read.
 *
 * Sample Input:
 *
 * books=[10, 20, 30, 15]
 * students = 2
 *
 * Sample Output:
 * 45
 */
public class ReadingBooks {
    public static void main(String[] args) {
        System.out.println(readingBooksMinimizeMaximum(new int[]{10, 20, 30, 40}, 2));
    }

    // minimize the maximum
    private static int readingBooksMinimizeMaximum(int[] arr, int numStudents) {
        int s = arr[0];
        int e = Arrays.stream(arr).sum();
        int mid, ans = Integer.MAX_VALUE;
        while (s <= e) {
            mid = (s + e) / 2;
            if (canAllocateOptimally(arr, numStudents, mid)) {
                ans = mid;
                e = mid - 1; // since the goal is to minimize expand search towards left
            } else {
                s = mid + 1; // If further expansion towards left not possible then try expanding right
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
