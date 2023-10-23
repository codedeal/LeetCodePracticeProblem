package org.RevisionPractice;

import java.util.Arrays;

public class ArrayProblem
{
    public static  void findKthLargest(int []nums,int k)
    {
        Arrays.sort(nums);
        System.out.println(nums[nums.length-k]);

    }
    public static void main(String[] args) {

        findKthLargest(new int[]{3, 2, 1, 5, 6, 4},2);
    }
}
