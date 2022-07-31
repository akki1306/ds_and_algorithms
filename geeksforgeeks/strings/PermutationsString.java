package geeksforgeeks.strings;

import java.util.*;

public class PermutationsString {
    public static void main(String[] args) {
        List<String> output = new ArrayList<>();
        permute("ABB",0,2, output);
        System.out.println(output);
    }

    private static void permute(String str, int l, int r, List<String> output) {
        if (l == r)
            output.add(str);
        else {
            HashSet set = new HashSet();
            for (int i = l; i <= r; i++) {
                if(set.contains(str.charAt(i)))
                    continue;
                set.add(str.charAt(i));
                str = swap(str, l, i);
                permute(str, l + 1, r, output);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] c = str.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
