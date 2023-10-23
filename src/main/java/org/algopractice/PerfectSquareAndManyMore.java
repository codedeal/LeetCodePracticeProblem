package org.algopractice;

import java.util.Arrays;

public class PerfectSquareAndManyMore
{

    public static int numsquare(int n)
    {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }


    public static int[] SquareOFSortedArray(int nums[])
    {
        for (int i=0;i<nums.length;i++)
        {
            nums[i]= (int) Math.pow(nums[i],2);
        }
         Arrays.sort(nums);
        return nums;
    }

    public static int[] rotate(int nums[],int k)
    {
        int n=nums.length;
        k=k%n;
        //Reveres the entire array
        reverse(nums,0,n-1);

        //Reverse the first k element
        reverse(nums,0,k-1);

        //Reverse the element after k
        reverse(nums,k,n-1);

        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private static void reverse(int[] nums, int start, int end)
    {
        while (start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println( numsquare(4));
        rotate(new int []{1,2,3,4,5,6,7},3);

    }
}
