package org.practiceproblem;

import java.io.PrintStream;

public class LearnRecursion
{
    public static void printNumberFrom1NTo1(int n)
    {
        if(n==0)
            return; //base case
        System.out.println(n);
        printNumberFrom1NTo1(n-1);
    }

    public static void reversestring(String str, int index)
    {

        if(index==0)
        {
            System.out.println(str.charAt(index));
            return;
        }
        System.out.println(str.charAt(index));
        reversestring(str,index-1);
    }


    static int first=-1;
    static  int last=-1;
    public static void findOccurence(String str, int idx,char element)
    {

        if(idx==str.length())
        {
            System.out.println("first "+first);
            System.out.println("Last "+last);
            return;
        }
        char curr=str.charAt(idx);
        if(curr==element)
        {
            if(first==-1)
                first=idx;
            else
                last=idx;
        }
        findOccurence(str,idx+1,element);
    }

    public static boolean isSorted(int []arr,int idx)
    {
        if(idx==arr.length-1)
            return true;
        if(arr[idx]<arr[idx+1])
          return  isSorted(arr,idx+1);
        else
            return false;
    }

    public static void moveAllX(String str,int idx,int count ,String newString)
    {
        if(idx==str.length())
        {
            for(int i=0;i<count;i++)
                newString+='X';
            return;
        }
        if(str.charAt(idx)=='X')
        {
            count++;
            moveAllX(str,idx+1,count,newString);
        }
        else
        {
            newString+=str.charAt(idx);
            moveAllX(str,idx+1,count,newString);
        }

    }

    public static  void subsequence(String s,int idx,String newstring)
    {
        if(idx==s.length())
        {
            System.out.print(newstring+"  ");
            return;
        }
        char curr=s.charAt(idx);
        subsequence(s,idx+1,newstring+curr);
        subsequence(s,idx+1,newstring);
    }
    public static void main(String[] args) {

        printNumberFrom1NTo1(5);
        reversestring("abcd",3);
        findOccurence("abaacdaefaah",0,'a');
        subsequence("abc",0,"");
    }
}
