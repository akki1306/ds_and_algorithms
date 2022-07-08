package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            String hash = getHash(s);
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(s);
            map.put(hash, list);
        }

        for (Map.Entry<String, List<String>> e : map.entrySet())
            groupAnagrams.add(e.getValue());

        return groupAnagrams;
    }

    private static String getHash(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        String ans = "";
        for (int i : arr)
            ans += i;

        return ans;
    }
}
