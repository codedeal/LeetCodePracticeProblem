package org.RevisionPractice;

public class MedianOfTwoArray
{
    public static double findMedian(int[]num1,int []num2)
    {
        int n1=num1.length;
        int n2=num2.length;
        int n=n1+n2;
        int final_arr[]= new int[n1+n2];
        int i=0,k=0,j=0;
        while (i<=n1&&j<=n2)
        {
            if(i==n1)
            {
                while (j<n2)
                    final_arr[k++]=num2[j++];
                break;
            }
            if(j==n2)
            {
                while (i<n1)
                    final_arr[k++]=num1[i++];
                break;
            }
            if(num1[i]>num2[j])
                final_arr[k++]=num2[j++];
            else
                final_arr[k++]=num1[i++];
        }

         if(n%2==0) return (float)(final_arr[n/2-1]+final_arr[n/2])/2;
           else return final_arr[n/2];
    }

    public static void main(String[] args) {
        System.out.println( findMedian(new int[]{4, 7, 3},new int[]{8,6,2,9} ));
    }
}
