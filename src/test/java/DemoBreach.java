import java.util.*;

public class DemoBreach
{
    /*Swap the values of the 2 strings WITHOUT USING THE THIRD VARIABLE: a="at Blackline. inTerView iS sChEdUleD fOr 1 Hour."
    b = "inTerView iS ScheDulEd"
    Output:
    a="inTerView iS ScheDulEd"
    b="at Blackline. inTerView iS sChEdUleD fOr 1 Hour."
    Concatenate b+a and then ensure that the new string is formatted to only have the starting letters as capitalized and the other letters are lower case.
    Output: Interview Is Scheduled At Blackline. Interview Is Scheduled For 1 Hour.
    Obtain the duplicate words in the string.
        Output: {Interview -> 2, Is ->2 ,Scheduled ->2}*/

    public static void problemStatement(String a,String b)
    {
        int size=a.length()+b.length();
        a=a+b;
        //appleorange -11 -total 11-6 =5

        b=a.substring(0,a.length()-b.length());
        a=a.substring(b.length(),size);

        System.out.println(a+" "+b);
        String res =a+" "+b;
        System.out.println(res);
        res.toLowerCase();
        System.out.println(res);
    }

    public static void main(String[] args)
    {
        problemStatement("apple","orange");

    }
}
