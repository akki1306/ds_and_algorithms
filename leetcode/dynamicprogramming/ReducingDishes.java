package leetcode.dynamicprogramming;

import java.util.Arrays;

public class ReducingDishes {
    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1, -8, 0, 5, -7}));
    }

    public static int maxSatisfaction(int[] satisfaction){
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int sum=0,k=n-1;
        for(int p=n-1;p>=0;p--)
        {
            sum+=satisfaction[p]; // check if the sum so far is still positive is starting from the right side of array
            // if the sum becomes negative then the negative numbers are overpowering the positive and multiplication
            // with time will only. Once the index is determined multiply break out of this for loop and multiply
            // by time in the next for loop.
            if(sum<0)
            {
                break;
            }
            k--;
        }
        k++;
        int ans=0,k1=1;
        for(int i=k;i<n;i++)
        {
            ans+=(satisfaction[i]*k1);
            k1++;
        }
        return ans;
    }
}
