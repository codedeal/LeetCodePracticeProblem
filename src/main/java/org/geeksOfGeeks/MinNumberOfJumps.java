package org.geeksOfGeeks;

public class MinNumberOfJumps
{
    public static void minNumbOfJump(int []arr)
    {
        int count=0;
        int i=0;
        int j=arr.length-1;
        while (i<j)
        {
            if(arr[i]>0)
            {
                i=i+arr[i];
                count++;
            }
        }

        System.out.println(count);

    }
    public static void main(String[] args) {
        minNumbOfJump(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
        minNumbOfJump(new int[]{1, 4, 3, 2, 6, 7});

        minNumbOfJump(new int[]{1, 4, 3, 0, 6, 7});
        minNumbOfJump(new int[]{2, 4, 3, 0, 6, 7});
    }
}
