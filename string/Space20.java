package string;

public class Space20 {
    public static void main(String[] args) {
        System.out.println(space20("this is a test"));
    }

    private static String space20(String s) {
        int spaceCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        spaceCount = spaceCount * 3 - spaceCount;

        char[] arr = s.toCharArray();
        char[] newArr = new char[s.length() + spaceCount];

        int j=arr.length-1;
        for (int i = newArr.length - 1; i >= 0; i--) {
            char c = arr[j--];
            if (c == ' ') {
                newArr[i] = '0';
                newArr[--i] = '2';
                newArr[--i] = '%';
            } else {
                newArr[i] = c;
            }
        }

        return new String(newArr);
    }
}
