package geeksforgeeks.arrays;

import java.util.ArrayList;

public class StockBuySell {
    public static void main(String[] args) {
        System.out.println(stockBuySell(new int[]{100,180,260,310,40,535,695}, 7));
    }

    //Function to find the days of buying and selling stock for max profit.
    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {

        ArrayList<ArrayList<Integer>> buySell = new ArrayList();
        int buy = 0;
        int max = 0;
        int sell = 0;
        for(int i=1;i<n;i++){
            if(A[i] - A[buy] > max) {
                max = Math.max(max, A[i] - A[buy]);
                sell = i;
            } else {
                if(buy!=sell) {
                    ArrayList<Integer> a = new ArrayList();
                    a.add(buy);
                    a.add(sell);
                    buySell.add(a);
                }
                max = 0;
                buy = i;
                sell = i;
            }
        }
        if(sell == n-1 && sell!=buy){
            ArrayList l = new ArrayList();
            l.add(buy);
            l.add(sell);
            buySell.add(l);
        }

        return buySell;
    }
}
