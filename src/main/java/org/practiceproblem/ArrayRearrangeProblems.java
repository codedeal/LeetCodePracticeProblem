package org.practiceproblem;


import java.util.Arrays;

/*   Write a program to sort an array of integers in ascending order.
        Write a program to sort an array of integers in descending order.
        Write a program to reverse an array of integers.
        Write a program to rotate an array of integers by a given number of positions to the left.
        Write a program to rotate an array of integers by a given number of positions to the right.
        Write a program to move all the zeroes in an array to the end of the array.
        Write a program to remove duplicates from an array of integers.
        Write a program to find the largest and smallest elements in an array of integers.
        Write a program to find the kth largest element in an array of integers.
        Write a program to rearrange an array such that all the negative elements come before the positive elements.
        Write a program to find the second smallest element in an array of integers.
        Write a program to find the median of an array of integers.
        Write a program to find the frequency of each element in an array of integers.
        Write a program to find the sum of two arrays of integers.
        Write a program to merge two sorted arrays of integers into a single sorted array.
        Write a program to find the intersection of two arrays of integers.
        Write a program to find the union of two arrays of integers.
        Write a program to find the maximum sum of a subarray in an array of integers.
        Write a program to find the length of the longest increasing subarray in an array of integers.
        Write a program to find the number of pairs of integers in an array whose sum is equal to a given target.*/
public class ArrayRearrangeProblems
{
    public static void sortInAscendingOrder(int nums[])
    {
       int temp=0;
       for(int i=0;i<nums.length;i++)
       {
           for(int j=i+1;j<nums.length;j++)
           {
               if(nums[i]>nums[j])
               {
                   temp=nums[i];
                   nums[i]=nums[j];
                   nums[j]=temp;
               }
           }
       }
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseAnArrayOfInteger(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void moveAllZeroToEnd(int arr[])
    {
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=0)
            {
                arr[count++]=arr[i];
            }
        }
        while (count<n)
            arr[count++]=0;

        System.out.println(Arrays.toString(arr));
    }
    public static void removeDuplicates(int arr[])
    {
        int n=arr.length;
        int res[]=new int[n];
        int j=0;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                res[j++]=arr[i];
            }
        }
        res[j++]=arr[n-1];
        int trimArray[]=Arrays.copyOf(res,j);
        System.out.println(Arrays.toString(trimArray));
    }
    public static void rerrangeAllNegativeBeforePositive(int arr[])
    {
        int n=arr.length;
        int rearrange[]= new int[n];
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<0)
            {
                rearrange[j++]=arr[i];
            }
        }

        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                rearrange[j++]=arr[i];
            }
        }
        System.out.println(Arrays.toString(rearrange));
    }
    public static void main(String[] args) {
       sortInAscendingOrder(new int[]{4,9,1,5,0});
       reverseAnArrayOfInteger(new int[]{3,5,1,88,0,2});
       moveAllZeroToEnd(new int[]{2,0,0,4,5,0,9,0});
        removeDuplicates(new int[]{2,3,3,4,4,5,5});
        rerrangeAllNegativeBeforePositive(new int[]{2,17,-68,-94,0,1,2,-3});
    }
}
