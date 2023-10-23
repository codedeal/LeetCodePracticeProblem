package org.geeksOfGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonEelement
{
    public static void commonEl(int[]arr1,int arr2[],int[]arr3)
    {
        List<Integer> common= new ArrayList<>();
        int i=0,j=0,k=0;

        while (i<arr1.length&&j<arr2.length&&k<arr3.length)
        {
           if(arr1[i]==arr2[j]&&arr2[j]==arr3[k])
           {
               i++;
               j++;
               k++;
           } else if (arr1[i]<arr2[j])
           {
               i++;

           } else if (arr2[j]<arr3[k])
           {
               j++;

           }
           else
           {
               k++;
           }
        }

    }
    public static void main(String[] args) {

    }
}
