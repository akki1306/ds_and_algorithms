package udemy.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a vector of numbers. You want to concatenate these numbers together to form the
 * lexicographically largest number. Print that largest number. You cant rearrange the digits of
 * any number, however you can place the numbers next to each other in any order.
 *
 * Input:
 *
 * 10, 11, 20, 30, 3
 *
 * Output:
 *
 * 330201110
 *
 */
public class BiggestNumberString {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 11, 20, 30, 3}));
    }

    // 10 11 20 30 3
    // 330201110
    public static String largestNumber(int[] nums) {
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(arr, new SortbyDigit());
        String ans = "";
        for (int num : arr)
            ans = ans + num;

        return ans.charAt(0) == '0' ? "0" : ans;
    }


    static class SortbyDigit implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return (x + "" + y).compareTo(y + "" + x)*-1;
        }
    }
}
