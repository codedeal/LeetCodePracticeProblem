package org.geeksOfGeeks;

import java.util.Arrays;

public class SortArrayOf01and2
{
    public static  void sort(int arr[])
    {
      int low=0;
      int mid=0;
      int high=arr.length-1;
      while (mid<high)
      {
          if(arr[mid]==0)
          {
              int temp=arr[mid];
              arr[mid]=arr[low];
              arr[low]=temp;
              low++;
              mid++;
          } else if (arr[mid]==1)
          {
              mid++;

          }else if (arr[mid]==2)
          {
              int temp=arr[high];
               arr[high]=arr[mid];
               arr[mid]=temp;
               high--;
          }
      }

        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
    }
    public static void main(String[] args) {
        sort(new int[]{1,2,0,2,1,0});
    }
}
