package org.revise0203;

import java.util.*;

public class Revise01
{
    public static void squareOfSortedArray(int []arr)
    {
        for(int i=0;i<arr.length;i++)
            arr[i]=(int)Math.pow(arr[i],2);
        Arrays.sort(arr);
        System.out.println( Arrays.toString(arr));
    }
    public static void rotateArrayKthPosition(int arr[],int k)
    {
        int n=arr.length;
        k=k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

        System.out.println( Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end)
    {
        while (start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

    }

    public static int binarySearch(int arr[],int key)
    {
        int low=0;
        int high=arr.length-1;
        while (low<high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==key)
                return mid;
            else if (arr[mid]<key)
            {
                low=mid+1;

            }else
            {
                high=mid-1;
            }
        }
        return -1;
    }
    public static void alternatePosAndNegNumber(int arr[])
    {
        Queue<Integer>posQueue= new LinkedList<>();
        Queue<Integer>negQueue= new LinkedList<>();
        for(int i:arr)
        {
            if(i>0)
                posQueue.add(i);
            else
                negQueue.add(i);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(i%2==0 && !posQueue.isEmpty())
                arr[i]=posQueue.poll();
            else if (i%2==1 && !negQueue.isEmpty())
            {
                arr[i]=negQueue.poll();

            } else if (!posQueue.isEmpty())
            {
                arr[i]=posQueue.poll();

            }
            else if (!negQueue.isEmpty())
            {
                arr[i]=negQueue.poll();
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void commonElement(int arr1[],int arr2[],int arr3[])
    {
        List<Integer>list = new ArrayList<>();
        int i=0,j=0,k=0;
        while (i<arr1.length&&j<arr2.length&&k<arr3.length)
        {
            if(arr1[i]==arr2[j]&&arr2[j]==arr3[k])
            {
                list.add(arr1[i]);
                i++;j++;k++;
            }
            else if (arr1[i]<arr2[j])
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
       list.forEach(x-> System.out.println(x));
    }
    public static void minNumberOfJump(int arr[])
    {
        int i=0;
        int count=0;
        while (i<arr.length)
        {
            if(arr[i]>0)
            {
                i=i+arr[i];
                count++;
            }

        }
        System.out.println("Jumps  "+count);

    }
    public static void moveAllZeroToEnd(int arr[])
    {
        int n=arr.length;
        int index=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
                arr[index++]=arr[i];

        }
        while (index<n)
        {
            arr[index++]=0;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void nextGreaterElement(int arr[])
    {
        int n=arr.length;
        Stack<Integer>stack= new Stack<>();
        int result[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while (!stack.isEmpty()&&arr[i]>=stack.peek())
                stack.pop();
            if(stack.isEmpty())
                result[i]=-1;
            else
                result[i]=stack.peek();
            stack.push(arr[i]);

        }
        System.out.println(Arrays.toString(result));
    }
    public static void findSmallerNumberToLeftOFArray(int arr[])
    {
        int n=arr.length;
        Stack<Integer>st= new Stack<>();
        int result[]= new int[n];
        for (int i=0;i<arr.length;i++)
        {
            while (!st.isEmpty()&&st.peek()>arr[i])
                st.pop();
            if(st.isEmpty())
                result[i]=-1;
            else
                result[i]=st.peek();
            st.push(arr[i]);

        }
        System.out.println(Arrays.toString(result));
    }
    public static void concatenateString(String []arr)
    {
        StringBuilder stringBuilder= new StringBuilder();
        int maxLen=0;
        for(String s:arr)
        {
            maxLen=Math.max(maxLen,s.length());
        }
        for(int i=0;i<maxLen;i++)
        {
            for(String s:arr)
            {
               if(i<s.length())
                   stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static int findMissingPositiveNumber(int nums[])
    {
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
        return nums.length;
    }
    public static void main(String[] args) {
        squareOfSortedArray(new int[]{1,2,3,4});
        rotateArrayKthPosition(new int []{1,2,3,4,5,6,7},1);
        System.out.println(binarySearch(new int []{3,4,7,11,13,45,53},11));
        alternatePosAndNegNumber(new int[]{1,4,5,-4,-6,-7,8-9,11});
        commonElement(new int[]{1,2,4},new int[]{1,2,5},new int[]{1,2,4});
        minNumberOfJump(new int[]{1,3,4,5,6});
        moveAllZeroToEnd(new int[]{2,0,5,0,7,0,1,1});
        nextGreaterElement(new int[]{4,5,2,25});
        findSmallerNumberToLeftOFArray(new int[]{1,6,4,10,2,5});
        concatenateString(new String[]{"Kitkat","Milkybar","Nestle"});
       // System.out.println(findMissingPositiveNumber(new int[]{1,2,0}));
        //System.out.println(findMissingPositiveNumber(new int[]{3,4,-1,1}));
        System.out.println(findMissingPositiveNumber(new int[]{3,4,-1,1,33}));
    }
}
