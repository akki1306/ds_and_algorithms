package sortingsearching;

public class SparseSearch {
    public static void main(String[] args) {
        String[] arr = {"ai", "", "", "bat", "", "", "car", "cat", "", "", "dog", "e"};
        int index = sparceSearch(arr, "e", 0, arr.length - 1);
        System.out.println(index>0?index:-1);
    }

    private static int sparceSearch(String[] arr, String search, int start, int end) {
        if (start >= end)
            return search.compareTo(arr[end])==0?end:-1;


            int mid = (start + end) / 2;
            if (arr[mid] == "") {
                int left = mid;
                while (arr[--left] == "" && left >= start) ;
                if (arr[left].compareTo(search) == 0)
                    return left;
                else if (search.compareTo(arr[left]) > 0) {
                    mid = (left + 1 + end) / 2;
                } else {
                    mid = (start + left - 1) / 2;
                }
            }

            if (arr[mid].compareTo(search) == 0) {
                return mid;
            } else if (search.compareTo(arr[mid]) > 0) {
                return sparceSearch(arr, search, mid + 1, end);
            } else {
                return sparceSearch(arr, search, start, mid - 1);
            }
    }
}
