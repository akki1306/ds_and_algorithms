package leetcode.heaps;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequentOptimized(new String[]{"the", "apple", "apple", "apple", "apple", "apple", "day", "day", "day", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 2));
        System.out.println(topKFrequentOptimized(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequentOptimized(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            int val = o1.getValue().compareTo(o2.getValue());
            if(val == 0)
                return o2.getKey().compareTo(o1.getKey());
            return val;
        });
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);

            if(pq.size() > k)
                pq.poll();
        }

        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        return res;
    }

    public static List<String> topKFrequentOptimized(String[] words, int k){
        Map<String,Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s, map.getOrDefault(s,0)+1);  // count words

        // define max heap that will sort based on string in case if the frequencies are same.
        PriorityQueue<String> pq=new PriorityQueue<>((a,b) -> map.get(b)==map.get(a)?a.compareTo(b):map.get(b)-map.get(a));

        // add all elements to heap. Heap will arrange elements based on the comparator defined.
        pq.addAll(map.keySet());

        // since its a max heap remove first k elements from the heap.
        List<String> ans=new ArrayList<>();
        while(k-->0) {
            ans.add(pq.poll());
        }
        return ans;
    }
}
