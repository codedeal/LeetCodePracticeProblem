package org.RevisionPractice;

import java.util.*;

public class Revision01
{

    public static void lengthOfCommonsSubstringWithoutRepetation(String s)
    {
        int maxLength=0;
        int n=s.length();
        int i=0,j=0;
        Set<Character> set = new HashSet<>();
        while (i<n&&j<n)
        {
            char c= s.charAt(j);
            if(!set.contains(c))
            {
                set.add(c);
                j++;
                maxLength=Math.max(maxLength,j-i);
            }else
            {
                set.remove(c);
                i++;
            }
        }

        System.out.println(maxLength);
    }

    public static void moveAllZeroToEnd(int nums[])
    {
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]==0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
    }


    public static void integerToRoman(int num)
    {
        String romanValue[]= {"M","CM","D","CD","C","XC","L","XL","V","IV","I"};
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb= new StringBuilder();
        int i=0;
       while (num>0)
       {
           if(num-values[i]>=0)
           {
               sb.append(romanValue[i]);
               num=num-values[i];
           }
           else
           {
               i++;
           }
       }
        System.out.println(sb.toString());
    }
    public static void RomanToInteger(String data)
    {
        Map<Character,Integer>map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
       int prevValue=0;
       int result=0;
       for(int i=data.length()-1;i>=0;i--)
       {
           int currentvalue =map.get(data.charAt(i));
           if(currentvalue<prevValue)
               result=result-currentvalue;
           if(currentvalue>prevValue)
               result=result+currentvalue;
           prevValue=currentvalue;
       }
        System.out.println(result);
    }

    public static boolean validParenthesis(String str)
    {
        Stack<Character>stack= new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void twoSumrev(int arr[],int targetSum)
    {
         Map<Integer,Integer>map= new HashMap<>();
         for(int i=0;i<arr.length;i++)
         {
             int sumLeft=targetSum-arr[i];
             if(map.containsKey(sumLeft))
             {
                 System.out.println("Index is "+map.get(sumLeft)+","+i);
                 return;
             }
             else
                 map.put(arr[i],i);
         }
    }

    public static int findPivotIndex(int []arr)
    {
        int left=0;
        int total=0;
        for (int i:arr)
        {
            total+=i;

        }
        for(int i=0;i<arr.length;i++)
        {
            if((total-arr[i]-left)==left)
                return i;
            left=left+arr[i];
        }
        return -1;
    }
    public static int findpeakElement(int []nums)
    {
        int left=0;
        int right=nums.length-1;
        while (left<right)
        {
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1])
            {
                right=mid;
            }else {
                left=mid+1;
            }
        }
        System.out.println(nums[left]);
       return left;

    }

    public static int[] removeDuplicateFromArray(int[]arr)
    {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    // Shift all elements to the left
                    for (int k = j; k < n - 1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--; // Decrease the length of the array
                    j--; // Update the index of the current element
                }
            }
        }
        return Arrays.copyOf(arr, n);
    }
    public static void main(String[] args) {
        lengthOfCommonsSubstringWithoutRepetation("abcdaaaaaa");
      moveAllZeroToEnd(new int[]{0,1,3,2,0,4});
      integerToRoman(950);
      RomanToInteger("CMC");
        System.out.println(validParenthesis("({[]})"));
        twoSumrev(new int[]{2,7,11,15},17);
        System.out.println(findPivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(findpeakElement(new int[]{1,2,3,1}));

      int res[]=  removeDuplicateFromArray(new int[]{1,2,3,4,2,4,3});
        System.out.println(Arrays.toString(res));
    }
}
