package org.practiceproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class LeetCodeProblems
{
    public static int[] nextGreater(int []num)
    {
        int n=num.length;
        int result[]= new int[n];
        Stack<Integer>stack= new Stack<>();
        for(int i=n-1;i>=0;i--)
        {

            while (!stack.isEmpty()&&num[i]>=stack.peek())
                stack.pop();
            if(stack.isEmpty())
                result[i]=-1;
            else
                result[i]=stack.peek();

            stack.push(num[i]);
        }
        return result;
    }

    public  static boolean lemondeChange(int []bills)
    {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5)  //if customer gives $5 then we simply take it as lemonade costs $5
                five++;
            else if (i == 10) { //if we have $10 then we reduce number of $5 bills by one and increase $10 by one
                five--; ten++;
            }
            else if (ten > 0 && five>=1) { //if we get $20 then we first try to give back $10+$5
                ten--; five--;
            }
            else        // if we cannot give back $10+$5 then unfortunately we have to give back $5+$5+$5
                five -= 3;
            if (five < 0)  // if at any time we do not have any $5 left then we return false
                return false;
        }
        return true;

    }
    public static int searchInsertPosition(int nums[],int target)
    {
        int left=0;
        int right=nums.length-1;
        while (left<=right)
        {
            int mid=left+(right-1)/2;
            System.out.println(mid);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                left=mid+1;
            else if(nums[mid]>target)
                right=mid-1;
        }
        return left;
    }

    public static void reverseWordInString(String s)
    {
        s = s.trim();
        String arr[]=s.split("\\s+ ");
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(arr[arr.length-1]+" ");
        for(int i=arr.length-2;i>=0;i--)
        {
            stringBuilder.append(arr[i]);
            if(i>0)
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());



    }
    public static String LargestNumber(int num[])
    {
        if(num==null||num.length==0)
            return "";
        //convert all integer to string
        String[]s_num= new String[num.length];
        for(int i=0;i<num.length;i++)
            s_num[i]=String.valueOf(num[i]);

        //Implement Compartor to decide which string come first
        Comparator<String>comp=new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String s1=o1+o2;
            String s2=o2+o1;
            System.out.println("s1="+s1);
            System.out.println("s2="+s2);
            return s2.compareTo(s1);
        }


    };
        Arrays.sort(s_num,comp);
        System.out.println(Arrays.toString(s_num));
        if(s_num[0].charAt(0)=='0')
            return "0";
        StringBuilder sb= new StringBuilder();
        for(String s:s_num)
            sb.append(s);

        return sb.toString();

    }
    public static void productOfArrayItself(int[]nums)
    {
        int n=nums.length;
        int output[]= new int[n];
        int left=1;
        for(int i=0;i<n;i++)
        {
            output[i]=left;
            left*=nums[i];
        }
        System.out.println(Arrays.toString(output));
        int right=1;
        for(int i=n-1;i>=0;i--)
        {
            output[i]*=right;
            right*=nums[i];
        }
        System.out.println(Arrays.toString(output));
    }

    public static void duplicateZero(int arr[])
    {
        int n=arr.length;
        int []result=new int[n];
       int i=0;
       int j=0;
       while (j<n&&i<n)
       {
           if(arr[i]==0)
           {
               result[j]=0;
               if(j+1<arr.length)
                   result[j+1]=0;
               j=j+2;
               i++;
           }
           else {
               result[j]=arr[i];
               j++;
               i++;
           }
       }

      

        System.out.println(Arrays.toString(result));
    }
    //You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them. ex abbaca"
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    public static void  removeAdjacentDeuplicateInString(String s)
    {
      Stack<Character> st= new Stack<>();
      for(int i=0;i<s.length();i++)
      {
          char c=s.charAt(i);
          if(st.isEmpty())
          {
              st.push(c);
          } else if (st.peek()==c)
          {
              st.pop();

          }
          else
              st.push(c);
      }
      String n="";
      while (!st.isEmpty())
          n=st.pop()+n;

        System.out.println(n);

    }

    public boolean isPowerOfTwo(int n)
    {
        if(n==0)
            return false;
        while(n!=1)
        {
            if(n%2!=0) return false;

            n=n/2;

        }

        return true;

    }

    public static int findMissingPositiveInteger(int nums[])
    {
        //https://leetcode.com/problems/first-missing-positive/description/

        int ans[] = new int[nums.length + 1];

        // mark the presence of each positive integer in the input array
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(val > 0 && val <= nums.length) { // check to avoid index out of bounds
                ans[val] = 1;
            }
        }

        // find the smallest missing positive integer by checking the array of marked integers
        for(int i = 1; i < ans.length; i++){
            if(ans[i] == 0){
                return i;
            }
        }

        // if no missing positive integer is found, return the length of the array
        return ans.length;
    }

    public static String concatenateStrings(String arr[])
    {
        StringBuilder sb = new StringBuilder();
        int maxLength=0;
        for(String s:arr)
        {
            maxLength=Math.max(maxLength,s.length());
        }
        for(int i=0;i<maxLength;i++)
        {
            for (String s:arr)
            {
                if(i<s.length())
                    sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

       System.out.println(Arrays.toString(nextGreater(new int[]{4,5,2,25})));
//        System.out.println(searchInsertPosition(new int[]{1,3,5,6},7));
//        reverseWordInString(" the sky is blue  ");
//
//        System.out.println(  LargestNumber(new int[]{3,20,34,5,9}));
//        productOfArrayItself(new int []{1,2,3,4});

    //    duplicateZero(new int[]{1,0,2,3,0,4,5,0});
  //      removeAdjacentDeuplicateInString("abbaca");

        System.out.println(findMissingPositiveInteger(new int[]{1,2,-1}));
        System.out.println(findMissingPositiveInteger(new int[]{1,2,0}));

        System.out.println(concatenateStrings(new String[]{"Rajiv","Sharma","Gupta","Vinod"}));

    }
}
