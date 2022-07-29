package udemy.string;

import java.util.ArrayList;
import java.util.List;

public class SearchAll {
    public static void main(String[] args) {
        System.out.println(findAllOccurrenceOfWordInString("I liked the movie, acting in movie was great!", "movie"));
    }

    private static List<Integer> findAllOccurrenceOfWordInString(String s, String w) {
        int i = 0;
        List<Integer> l = new ArrayList<>();
        while (i < s.length()) {
            int indx = s.indexOf(w, i);
            if (indx != -1) {
                l.add(indx);
                i = indx + 1;
            } else {
                break;
            }
        }
        return l;
    }
}
