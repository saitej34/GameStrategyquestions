import java.util.*;
class Predictthewinner 
{
    public boolean PredictTheWinner(int[] nums)
     {
        int start=0,end = nums.length-1;
        int[][] dp = new int[nums.length][nums.length];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        int p1 = findAns(nums,start,end,dp);
        int tot = 0;
        for(int i=0;i<nums.length;i++)
        {
            tot += nums[i];
        }
        int p2 = tot - p1;
        if(p1>=p2)
        {
            return true;
        }
        return false;
    }
    public static int findAns(int[] nums,int start,int end,int[][] dp)
    {
        if(start>end)
        {
            return 0;
        }
        if(start==end)
        {
            return nums[start];
        }
        if(dp[start][end]!=-1)
        {
            return dp[start][end];
        }
        int takestart = nums[start] + Math.min(findAns(nums,start+2,end,dp),findAns(nums,start+1,end-1,dp));
        int takeend = nums[end] + Math.min(findAns(nums,start+1,end-1,dp),findAns(nums,start,end-2,dp));
        return dp[start][end] = Math.max(takestart,takeend);
    }
}