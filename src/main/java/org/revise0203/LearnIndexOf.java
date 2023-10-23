package org.revise0203;

public class LearnIndexOf
{
    public static void  occurenceOfsubstringInString(String str,String substr)
    {
        int count=0;
        int index=str.indexOf(substr);
        while (index!=-1)
        {
            count++;
            index=str.indexOf(substr,index+substr.length());
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        String s="Hello World";
        System.out.println(s.indexOf("orld"));
        System.out.println(s.indexOf("o",5));
        System.out.println(s.indexOf('d'));
        occurenceOfsubstringInString("abcdefababdfgabdfabxyzab","ab");

    }
}
