package org.geeksOfGeeks;

public class KandanAlgoProblem
{
  //  Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
    public static void maxSum(int arr[])
    {
        int maxSum=arr[0];
        int currSum=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            currSum=Math.max(arr[i],currSum+arr[i]);
            maxSum=Math.max(currSum,maxSum);
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        maxSum(new int[]{1,2,3,-2,5});
    }
}
