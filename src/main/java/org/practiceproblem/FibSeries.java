package org.practiceproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibSeries
{

    public static  void printFib(int n)
    {
        int a=0;
        int b=1;
        int c=0;
        List<Integer>li= new ArrayList<>();
        System.out.println(a);
        for(int i=1;i<n;i++)
        {
            c=a+b;
           li.add(c);
            b=a;
            a=c;


        }
        for (int i:li)
        {
            System.out.println(i);

        }
    }
    public static void main(String[] args) {
        printFib(5);
    }
}
