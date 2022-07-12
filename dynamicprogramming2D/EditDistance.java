package dynamicprogramming2D;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minimumEdits("geek", "gessek", 0, 0));
    }

    private static int minimumEdits(String s1, String s2, int i, int j) {
        if (i >= s1.length() && j < s2.length())
            return s2.length() - j;

        if (j >= s2.length() && i < s1.length())
            return s1.length() - i;

        if (i >= s1.length() && j >= s2.length())
            return 0;

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if (c1 == c2)
            return minimumEdits(s1, s2, i + 1, j + 1);

        int remove = minimumEdits(s1, s2, i + 1, j);
        int insert = minimumEdits(s1, s2, i, j + 1);
        int replace = minimumEdits(s1, s2, i + 1, j + 1);
        return 1 + Math.min(replace, Math.min(remove, insert));
    }
}
