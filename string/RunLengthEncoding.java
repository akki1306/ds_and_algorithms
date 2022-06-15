package string;

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
