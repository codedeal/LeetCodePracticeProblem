package org.algopractice;

public class SearchUsingBinary
{

   // Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    public static int search(int[] nums, int target) {
         int left=0;
         int right=nums.length-1;
         while (left<=right)
         {
             int mid= left+(right-left)/2;
             if(nums[mid]==target)
                 return mid;
             else if(nums[mid]<target)
                 left=mid+1;
                else
                    right=mid-1;
         }

         return -1;
    }
    public static void main(String[] args) {

        System.out.println( search(new int[]{-1,0,3,5,9,12},9));
    }
}
