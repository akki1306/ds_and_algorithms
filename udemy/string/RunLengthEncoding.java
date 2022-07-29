package udemy.string;

/**
 * Write a function that performs basic udemy.string compression using the counts of repeated
 * characters, also known as Run Length Encoding. Lets see one example, the input udemy.string
 * "aaaaabcccccaaa" would become "a4b1c5a3". If the compressed udemy.string would not become smaller
 * than the original udemy.string, your function should return the input udemy.string. You can assume that
 * the udemy.string has upper case and lower case letters. You may use the to_string method to convert integer
 * to udemy.string.
 *
 * Sample Input:
 *
 * bbbaaaadexxxxxx
 * abc
 *
 * Sample Output:
 * b3a4d1e1x6
 * abc
 *
 */
public class RunLengthEncoding {
    public static void main(String[] args) {
        //System.out.println(compressString("aaaabcccccaaa"));
        System.out.println(compressString("abc"));
    }

    private static String compressString(String s) {
        char[] c = s.toCharArray();

        int n = c.length;
        String ret = "";
        char prevChar = '*';
        int count = 1;
        for (int i = 0; i < n; i++) {
            if(prevChar!='*') {
                if (prevChar == c[i]) {
                    count++;
                } else {
                    ret = ret + prevChar + count;
                    count = 1;
                }
            }
            prevChar = c[i];
        }
        ret = ret + prevChar + count;
        return ret.length() < s.length() ? ret : s;
    }
}
