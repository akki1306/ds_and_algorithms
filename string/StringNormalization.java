package string;

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
