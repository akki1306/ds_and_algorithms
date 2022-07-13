package string;

/**
 * You are given a sentence with words seperated by spaces.
 *
 * Your task is to:
 *
 * Write a function that returns a copy of this sentence where all the words:
 *
 * . Start with a capital letter
 * . the rest of the letters are lower case
 *
 * Your function should not modify the sentence given as argument.
 *
 * Sample Input:
 * This is SO MUCH FUN!
 *
 * Sample Output:
 * This Is So Much Fun!
 */
public class StringNormalization {
    public static void main(String[] args) {
        System.out.println(normalize("This is SO MUCH FUN!"));
    }

    private static String normalize(String sentence) {
        char[] c = sentence.toCharArray();

        int j;
        for (int i = 0; i < c.length; i = j + 1) {
            c[i] = Character.toUpperCase(c[i]);
            for (j = i + 1; j < c.length && c[j] != ' '; j++) {
                c[j] = Character.toLowerCase(c[j]);
            }
        }
        return new String(c);
    }
}
