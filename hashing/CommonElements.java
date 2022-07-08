package hashing;

import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 45, 54, 71, 76, 12);
        List<Integer> l2 = Arrays.asList(1, 7, 5, 4, 6, 12);
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < l1.size(); i++) {
            map.putIfAbsent(l1.get(i), 1);
        }

        for (int i = 0; i < l2.size(); i++) {
            if(map.containsKey(l2.get(i)))
                res.add(l2.get(i));
        }

        Collections.sort(res);
        System.out.println(res);
    }
}
