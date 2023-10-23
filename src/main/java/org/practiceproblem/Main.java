package org.practiceproblem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String[] removeDuplicate(String []arr)
    {
        List<String>li = new ArrayList<>();
        for(String s:arr)
        {
            if(!li.contains(s))
                li.add(s);
        }
        return li.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}