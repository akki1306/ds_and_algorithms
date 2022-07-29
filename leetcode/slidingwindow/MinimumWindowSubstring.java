package leetcode.slidingwindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        //System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));

        String s = "";
        System.out.println(s.substring(0));

       // System.out.println("1-2--3-1".indexOf("\\d-\\d", "1-2--3-1".indexOf("\\d-\\d")));
        String traversal = "1-2--3--4";
        int indexOfLeftTree = getIndexOfLeftTree(traversal,  2);
        int indexOfRightTree = getIndexOfLeftTree(traversal.substring(indexOfLeftTree),  2);
       // System.out.println(indexOfLeftTree);
       // System.out.println(indexOfRightTree);
    }

    private static int getIndexOfLeftTree(String traversal, int level){
        if(level == 0)
            return traversal.charAt(0)-'0';


        int count = 0;
        int i=0;
        int currentLevel = 0;
        while(i<traversal.length()) {
            count = 0;
            while(traversal.charAt(i)=='-') {
                count++;
                i++;
            }

            if(Character.isDigit(traversal.charAt(i)) && count == level){
                currentLevel++;
            }

            if(currentLevel > 1) {
                return i-level;
            }
            i++;
        }
        return i-1;
    }

    public static String minWindow(String s, String t) {
        int[] tMap = new int[128];
        for (int i = 0; i < t.length(); i++)
            tMap[t.charAt(i)]++;

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int maxI = 0;
        int maxJ = 0;
        int cnt = t.length();
        boolean isValidWindowFound = false;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (tMap[ch] > 0)
                cnt--;
            tMap[ch]--;

            //contract left
            while (cnt == 0) {
                if (minLen > j - i + 1) {
                    isValidWindowFound = true;
                    maxI = i;
                    maxJ = j;
                    minLen = j - i + 1;
                }

                char c2 = s.charAt(i);
                tMap[c2]++;
                if (tMap[s.charAt(i)] > 0)
                    cnt++;
                i++;
            }
            // expand right
            j++;
        }
        return isValidWindowFound ? s.substring(maxI, maxJ + 1) : "";
    }
}
