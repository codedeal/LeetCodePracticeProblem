package org.practiceproblem;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray
{

    public static int minLegthofDegreeofArray(int []arr)
    {
        int degree=0;
        Map<Integer,Integer> num_count= new HashMap<>();
        Map<Integer,Integer>first_seen= new HashMap<>();
        int minLength=0;
        for(int i=0;i<arr.length;i++)
        {
            first_seen.putIfAbsent(arr[i],i);
            num_count.put(arr[i],num_count.getOrDefault(arr[i],0)+1);
            if(num_count.get(arr[i])>degree)
            {
                degree=num_count.get(arr[i]);
                minLength=i-first_seen.get(arr[i])+1;
            }
            else if(num_count.get(arr[i])==degree)
            {
                 minLength=Math.min(minLength,1-first_seen.get(arr[i])+1);
            }
        }
        System.out.println(degree);

        num_count.forEach((key,value)-> System.out.println("K= "+key+"   V="+value));

        first_seen.forEach((key,value)-> System.out.println("F K= "+key+"   F V="+value));
        System.out.println();
        return minLength;
    }
    public static void main(String[] args)
    {
        System.out.println(  minLegthofDegreeofArray(new int []{1,2,2,3,1,2}));

        System.out.println(  minLegthofDegreeofArray(new int []{1,1,2,2,2,1}));

    }
}
