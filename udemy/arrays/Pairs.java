package udemy.arrays;

import java.util.*;

/**
 * Given an array containing N integers, and an Number S denoting a target sum.
 *
 * Find two distinct integers that can pair up to form target sum.
 * Assume that there will be only one such pair.
 *
 * Input
 * array=[10,5,2,3,-6,9,11]
 * S=4
 *
 * Output
 * [10,-6]
 *
 */
public class Pairs {
    public static void main(String[] args) {
            List<Integer> input = Arrays.asList(10,5,2,3,-6,9,11);
            int[] res = findPairsBruteForce(input, 4);
            System.out.println(res[0] + "," + res[1]);

            res = findPairsSorting(input, 4);
            System.out.println(res[0] + "," + res[1]);

            res = findPairsUsingSet(input, 4);
            System.out.println(res[0] + "," + res[1]);

    }

    // Brute Force, O(N2)
    private static int[] findPairsBruteForce(List<Integer> input, int sum){
        int[] res = new int[2];

        // Boundary condition
        if(input.size()==2){
            if(input.get(0) + input.get(1) == sum) {
                res[0] = input.get(0);
                res[1] = input.get(1);
                return res;
            }else{
                return null;
            }
        }

        // O(n2)
        for(int i=0;i<input.size()-1;i++){
            for(int j=i+1;j<input.size();j++){
                Integer first = input.get(i);
                Integer second = input.get(j);
                if(first + second == sum){
                    res[0]= first;
                    res[1]= second;
                }
            }
        }
        return res;
    }

    // Sorting, O(NLogN)
    private static int[] findPairsSorting(List<Integer> input, int sum){
        int[] res = new int[2];

        // Boundary condition
        if(input.size()==2){
            if(input.get(0) + input.get(1) == sum) {
                res[0] = input.get(0);
                res[1] = input.get(1);
                return res;
            }else{
                return null;
            }
        }

        Collections.sort(input);

        for(int i=0;i<input.size();i++){
            int first = input.get(i);
            int second = Collections.binarySearch(input, sum - first);

            if(second!=-1){
                res[0]=first;
                res[1]=sum-first;
            }
        }

        return res;
    }

    // Using a set, O(N)
    private static int[] findPairsUsingSet(List<Integer> input, int sum){
        int[] res = new int[2];

        // Boundary condition
        if(input.size()==2){
            if(input.get(0) + input.get(1) == sum) {
                res[0] = input.get(0);
                res[1] = input.get(1);
                return res;
            }else{
                return null;
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<input.size();i++){
            if(set.contains(sum-input.get(i))){
                res[0]=input.get(i);
                res[1]=sum-input.get(i);
                break;
            }
            set.add(input.get(i));
        }
        return res;
    }
}
