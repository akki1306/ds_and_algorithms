package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You are given a string, you need to print all subsequences
 * of the string sorted by length and lexicographically sorted order
 * if the length is same.
 *
 * Sample Input:
 * abcd
 *
 * Sample Output:
 * ,a,b,c,d,ab,ac,ad,bc,bd,cd,abc,abd,acd,bcd,abcd
 */
public class SortSubsequences {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        sortSubsequences(0, "this".toCharArray(), s, "");
        Collections.sort(s, (o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);

            return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
        });
        System.out.println(s);
    }

    private static void sortSubsequences(int i, char[] s, List<String> list, String temp) {
            if (i == s.length) {
            if(temp!="") {
                list.add(temp);
            }
            return;
        }

        sortSubsequences(i + 1, s, list, temp + s[i]);
        sortSubsequences(i + 1, s, list, temp);

    }
}
