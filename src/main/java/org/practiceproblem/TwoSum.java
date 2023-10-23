package org.practiceproblem;

import java.math.BigInteger;
import java.util.*;

public class TwoSum

{
    public static int[] twoSum(int []arr,int target)
    {
        Map<Integer,Integer>map= new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(target-arr[i]))
            {
                return new int []{map.get(target-arr[i]),i};
            }
            else
                map.put(arr[i],i);
        }
        return new int[0];
    }

    public static int findPivotIndex(int []nums)
    {

        //https://leetcode.com/problems/find-pivot-index/
        int leftSum=0;
        int totalSum=0;
        for (int i:nums)
        {
            totalSum=totalSum+i;

        }
        for(int i=0;i<nums.length;i++)
        {
            if(totalSum-leftSum-nums[i]==leftSum)
                return i;
            leftSum=leftSum+nums[i];
        }
        return -1;
    }
    public static  int[] runningSumOf1dArray(int nums[])
    {
        int sum[]= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int temp=0;
            for(int j=0;j<=i;j++)
            {
                temp+=nums[j];
            }
            sum[i]=temp;
        }
        return sum;
    }

    public static  int[] runningSumOf1dArrayWay2(int nums[])
    {
//        I/p -1,2,3,4,5
//                O/P -1,3,6,10,15

       int n=nums.length;
       int[] sum= new int[n];
       sum[0]=nums[0];
       for(int i=1;i<n;i++)
           sum[i]=sum[i-1]+nums[i];
       return sum;
    }
    public boolean isSubsequence(String s,String t)
    {
       int i=0;
       int j=0;
        while (i<s.length()&& j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
                i++;

            j++;
        }
    return i==s.length();
    }

    public static void factorialOfBigNo()
    {
        BigInteger factorial=BigInteger.ONE;
        int number=20;
        for(int i=2;i<=20;i++)
        {
            factorial=factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
    public static List<List<Integer>> threeSum(int []nums)
    {
        //https://leetcode.com/problems/3sum/
        Set<List<Integer>> set=new HashSet<>();
        if(nums.length==0)return new ArrayList<>();
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length-2;i++)
        {
            int j=i+1;
            int k=nums.length-1;
            while (j<k)
            {
                sum=nums[i]+nums[j]+nums[k];
                if(sum==0) set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                if(sum<0)j++;
                if(sum>0)k--;
            }
        }
        return new ArrayList<>(set);
    }

    public static int[] findFirstAndLastPosition(int nums[],int target)
    {
        int res[]= new int[2];
        int f=-1;
        int last=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(target==nums[i])
            {
                if(f==-1)
                    f=i;
                else
                    last=Math.max(last,i);
            }
        }
        res[0]=f;
        res[1]=last;
        return res;
    }
    public static void main(String[] args) {
        //factorialOfBigNo();
        System.out.println(Arrays.toString(twoSum(new int []{2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum(new int []{3,6,2,1},8)));
        System.out.println(  findPivotIndex(new int[]{1,2,3}));
        System.out.println(  findPivotIndex(new int[]{1,7,3,6,6,5})); //28

        System.out.println(Arrays.toString(runningSumOf1dArrayWay2(new int []{1,2,3,4})));
    }

}
