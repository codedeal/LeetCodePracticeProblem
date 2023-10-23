package org.practiceproblem;

import java.util.*;

/* Write a program to reverse a string.
        Check if a given string is a palindrome.
        Write a program to count the occurrences of each character in a string.
        Remove all duplicates from a given string.
        Find the first non-repeated character in a string.
        Check if two strings are anagrams.
        Write a program to count the number of words in a string.
        Reverse the order of words in a given sentence.
        Check if a string is a rotation of another string.
        Find the longest substring without repeating characters.
        Given a string, find the longest palindromic substring within it.
        Implement a function to perform string compression (e.g., "aabbbcccc" becomes "a2b3c4").
        Remove all spaces from a string.
        Write a program to check if a string is a valid parentheses expression.
        Find the minimum window substring from a larger string containing all characters of a sma*/
public class StringProblems
{
    public static void StringCompression(String str)
    {
        String s= String.valueOf(str.charAt(0));
        int count=1;
        for(int i=1;i<str.length();i++)
        {

            char curr=str.charAt(i);
            char prev=str.charAt(i-1);
            if(curr==prev)
                count++;
            else {
                if (curr != prev) {
                    s += count;
                    count = 1;
                }
                s+=curr;
            }
        }
        System.out.println(s);
    }
    public static boolean findIfAStringIsSubstringOfOther(String mainString, String subString)
    {
        int mainLen=mainString.length();
        int sub=subString.length();
        for(int i=0;i<=(mainLen-sub);i++)
        {
            int j;
            for (j=0;j<sub;j++)
            {
                if(mainString.charAt(i+j)!=subString.charAt(j))
                    break;

            }
            if(j==sub)
            {
                System.out.println("YES it' Substring");
                return true;
            }
        }
     return false;
    }

    public static void removeDuplicateCharacterFromString(String str)
    {
        //You can use Set
        Set<Character>set= new HashSet<>();
        for (Character c:str.toCharArray())
        {
            if(!set.contains(c))
                set.add(c);
        }
        StringBuilder sb= new StringBuilder();
        for(char c: set)
        {
            sb.append(c);
        }
        System.out.println(sb);

        //Othe method
        StringBuilder stringBuilder= new StringBuilder();
        boolean []visited= new boolean[256];//ASCII value of char - not by default boolean isfasle
        for(int i=0;i<str.length();i++)
        {
            char current=str.charAt(i);
            if(!visited[current])
            {
                visited[current]=true;
                stringBuilder.append(current);

            }
        }
        System.out.println(stringBuilder.toString());
    }
    public static Character findFirstNonRepeatedCharacterString(String str)
    {
        Map<Character,Integer>map= new HashMap<>();
        for(char c:str.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        for(char c:str.toCharArray())
            if(map.get(c)==1)
                return c;
        return '\0';
    }
    public static void replaceToLArgestNumberToItsRight(int arr[])
    {
        //    Replace with the largest number to its right
//    A = [1,2,10,7,1,9]
//    Result = [10,10,9,9,9,-1]
        int n=arr.length;
        int []res=new int[n];
        int max=-1;
        for(int i=n-1;i>=0;i--)
        {
            int curr=arr[i];
            arr[i]=max;
            if(curr>max)
                max=curr;
        }
        System.out.println(Arrays.toString(arr));

    }
    public static void stringCompression2(String str)
    {
        String s=String.valueOf(str.charAt(0));
        int count=1;
        for(int i=1;i<str.length();i++)
        {
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);
            if(curr==prev)
                count++;
            else
            {
                if(curr!=prev)
                {
                    s+=count;
                    count=1;
                }
                s+=curr;
            }
        }
        System.out.println(s);
    }
    public static void main(String[] args) {
        StringCompression("aabbbbcccccddddeef");
        System.out.println(findIfAStringIsSubstringOfOther("Umbrealla","brealla"));
        removeDuplicateCharacterFromString("aabbccddDDCC");
        System.out.println(findFirstNonRepeatedCharacterString("ello World"));
        replaceToLArgestNumberToItsRight(new int[]{1,2,10,7,1,9});
        stringCompression2("aabbbbcccccddddeef");
    }
}
