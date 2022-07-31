package geeksforgeeks.sligingwindow;

public class SmallestWindowInSubstringContainingAllCharacterOfAnother {
    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice","toc"));
    }
    public static String smallestWindow(String s, String p)
    {
        int n = s.length();
        int i=0, j=0;
        int minI = n;
        int minJ = 2*n;
        int[] pMap = new int[26];
        int[] sMap = new int[26];

        for(int k=0;k<p.length();k++) {
            pMap[p.charAt(k) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        while(j<n && i<=j) {
            char ch = s.charAt(j);
            sMap[ch - 'a']++;
            if(sMap[ch -'a'] == 1 && pMap[ch -'a']==1)
                cnt++;

            if(cnt == p.length()) {  // contract left
                if((j - i + 1) < (minJ - minI + 1)) {
                    minI = i;
                    minJ = j;
                }

                while(cnt == p.length() && i<n) {
                    sMap[s.charAt(i) - 'a']--;
                    if(sMap[s.charAt(i) - 'a'] == 0 && pMap[s.charAt(i) - 'a']==1)
                        cnt--;
                    i++;
                }
            }


            j++; //expand right
        }

        System.out.println("MIN I : " + minI + " MIN J " + minJ);

        return "";
        //return s.substring(minI, minJ);
    }
}
