package udemy.hashing;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingLetter {
    public static void main(String[] args) {
        System.out.println((char)firstRepeatingLetter("codingminutes"));
    }

    private static int firstRepeatingLetter(String input){
        Set<Character> s = new HashSet<>();
        char[] arr = input.toCharArray();
        for(int i=0;i<arr.length;i++)
            if(s.contains(arr[i]))
                return arr[i];
            else
                s.add(arr[i]);
        return -1;
    }
}
