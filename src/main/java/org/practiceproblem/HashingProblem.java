package org.practiceproblem;

import java.util.*;

public class HashingProblem
{

    //find all element appear in array with frequency >n/3
    public static void findMajorityElement(int arr[])
    {
        int n= arr.length;
        Map<Integer,Integer>map= new HashMap<>();
        for(int i:arr)
        {
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i,1);
        }

        for (int key:map.keySet())
            if(map.get(key)>n/3)
                System.out.println(key);
    }

    public static int intersectionOfTwoArray(int arr1[],int arr2[])
    {
        HashSet<Integer>set= new HashSet<>();
        List<Integer>li= new ArrayList<>();
        int count =0;
        for(int i:arr1)
            set.add(i);
        for(int i:arr2)
        {
            if(set.contains(i))
            {
                count++;
                li.add(i);
                set.remove(i);
            }
        }
      for (int i:li)
      {
          System.out.println(i);
      }
        return count;
    }


    public void finsSumArraySumEqualK(int arr[],int k)
    {
        Map<Integer,Integer>map= new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(map.containsKey(sum-k))
            {
                ans+=map.get(sum-k);
            }
            else
                if(map.containsKey(sum))
                    map.put(sum,map.get(sum)+1);
                else
                    map.put(sum,1);
        }

    }

    public static void main(String[] args) {
        findMajorityElement(new int []{2,2,1,4,2,5,});
        intersectionOfTwoArray(new int[]{7,3,9},new int[]{6,3,9,8,0});
    }
}
