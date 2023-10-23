package org.revise0203;

import java.util.*;

public class Revision0
{
    public static void lengthOfLongrstSubstring(String s)
    {
        int maxLen=0;
        int i=0,j=0;
        int n=s.length();
        Set<Character>set= new HashSet<>();
        while (i<n&&j<n)
        {
            char c=s.charAt(j);
            if(!set.contains(c))
            {
                set.add(c);
                j++;
                maxLen=Math.max(maxLen,j-i);

            }
            else
            {
                set.remove(c);
                i++;
            }
        }
        System.out.println(maxLen);
    }
    public static void threeSum(int arr[])
    {
        //step 1 sort array
        Arrays.sort(arr);
        //step 2 create hashet
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<arr.length-2;i++)
        {
            //step 3
            int j=i+1;
            int k=arr.length-1;
            while (j<k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    set.add(Arrays.asList(arr[i], arr[j++], arr[k--]));
                }
                if (sum > 0)
                    j++;
                if (sum < 0)
                    k--;
            }
        }
        System.out.println(set);
    }
    public static int pivotIndex(int arr[])
    {
        //The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
        int totalSum=0;
        int leftSum=0;
        for (int i:arr)
        {
            totalSum+=i;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(totalSum-leftSum-arr[i]==leftSum)
                return i;
            leftSum=leftSum+arr[i];
        }
        return -1;
    }
    public static boolean containDuplicate(int arr[])
    {
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]==arr[i+1])
                return true;
        }
        return false;
    }
    public static boolean containDuplicateWay2(int arr[])
    {
        HashSet<Integer>set= new HashSet<>();
        for(int i:arr)
        {
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
    public static boolean checkStraightLine(int[][]coordinates)
    {

           if(coordinates.length<=2)
               return true;
           int x0=coordinates[0][0];
        int x1=coordinates[1][0];
        int y0=coordinates[0][1];
        int y1=coordinates[1][1];
        int deltaX=x1-x0;
        int delataY=y1-y0;

        for(int i=2;i<coordinates.length;i++)
        {
            int x=coordinates[i][0];
            int y=coordinates[i][1];
            int currDeltaX=x-x0;
            int currDeltaY=y-y0;
            if(deltaX*currDeltaY!=delataY*currDeltaX)
                return false;
        }
        return true;
    }
    public static void kthLargest(int arr[], int key)
    {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n=arr.length;
        System.out.println(arr[n-key]);
    }
    public static void findsmallestNumberToLeftOFArray(int []arr)
    {
        int []res= new int[arr.length];
        Stack<Integer>stack= new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while (!stack.isEmpty()&&stack.peek()>arr[i])
                stack.pop();
            if(stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
    public static void moveAllNegativeNumberToEnd(int arr[])
    {

          int left=0;
          for(int i=0;i<arr.length;i++)
          {
              if(arr[i]>0)
              {
                  arr[left]=arr[i];
                  left++;
              }
          }
          while (left<arr.length)
          {
              arr[left++]=0;

          }
        System.out.println(Arrays.toString(arr));
    }
    public static int MaxSubArray(int[] arr)
    {
        int max=0;
        int sum=0;
        for(int i:arr)
        {
            sum=Math.max(sum,0)+i;
            max=Math.max(max,sum);
        }
       return max;
    }
    public static int[] removeDuplciates(int[] arr)
    {
              int n=arr.length;
              for(int i=0;i<arr.length;i++)
              {
                  for(int j=i+1;j<n;j++)
                  {
                      if(arr[i]==arr[j])
                      {
                          for(int k=j;k<n-1;k++)
                          {
                              arr[k]=arr[k+1];
                          }
                          n--;j--;
                      }

                  }
              }
              int res[]=Arrays.copyOf(arr,n);
        System.out.println(Arrays.toString(res));
        return res;
    }
    public static boolean findMountainArray(int arr[])
    {
        int n=arr.length;
        int i=0;
        int j=n-1;
        while (i<n&&arr[i]<arr[i+1])i++;
        while (j>0&&arr[j-1]>arr[j])j--;
        return i>0&&i==j&&j<n-1;



    }
    public static boolean isBalanced(String str)
    {
        Stack<Character>stack= new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(c=='('||c=='['||c=='{')
                stack.push(c);
           else if(c==')'||c=='}'||c==']')
            {
                if(stack.isEmpty())
                    return false;
            }
           char top=stack.pop();
            if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                return false;
            }
        }
      return stack.isEmpty();
    }
    public static void main(String[] args) {

        lengthOfLongrstSubstring("aaabcdddd");
        threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        kthLargest(new int[]{3,2,1,5,6,4},4);
        findsmallestNumberToLeftOFArray(new int[]{1,6,4,10,2,5});
        moveAllNegativeNumberToEnd(new int[]{2,0,4,0,5,0,7,1});
        removeDuplciates(new int[]{1,2,3,4,5,3,7,1});
    }
}
