package org.practiceproblem;

public class JumpProblem
{
    public static boolean canJump(int[] nums) {
    //https://leetcode.com/problems/jump-game/

        int maxJump=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>maxJump)
                return false;
            maxJump=Math.max(maxJump,i+nums[i]);
        }

        return true;
    }

    public static int jump(int[] nums) {
    //https://leetcode.com/problems/jump-game-ii/description/
        int n=nums.length;
        int jump=0;
        int currEnd=0;
        int currFarthest=0;
        for(int i=0;i<n-1;i++)
        {
            currFarthest=Math.max(currFarthest,i+nums[i]);
            if(i==currEnd)
            {
                jump++;
                currEnd=currFarthest;
            }
        }
     return jump;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
