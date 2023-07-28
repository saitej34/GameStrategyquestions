import java.util.*;
class Stonegame
 {
    public boolean stoneGame(int[] piles) 
    {
        int start = 0;
        int[][] dp = new int[piles.length][piles.length];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        int end = piles.length-1;
        int p1 = findAns(piles,start,end,dp);
        int totsc = 0;
        for(int i=0;i<piles.length;i++)
        {
            totsc = totsc + piles[i];
        }
        int p2 = totsc - p1;
        if(p1>=p2)
        {
            return true;
        }
        return false;
    }
    public static int findAns(int[] piles,int start,int end,int[][] dp)
    {
        if(start>end)
        {
            return 0;
        }
        if(start==end)
        {
            return piles[start];
        }
        if(dp[start][end]!=-1)
        {
            return dp[start][end];
        }
        int takei = piles[start] + Math.min(findAns(piles,start+2,end,dp),findAns(piles,start+1,end-1,dp)); 
        int takej = piles[end] + Math.min(findAns(piles,start+1,end-1,dp),findAns(piles,start,end-2,dp));
        return dp[start][end] = Math.max(takei,takej);
    }
}



// Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

// The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

// Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

// Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.

 

// Example 1:

// Input: piles = [5,3,4,5]
// Output: true
// Explanation: 
// Alice starts first, and can only take the first 5 or the last 5.
// Say she takes the first 5, so that the row becomes [3, 4, 5].
// If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
// If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
// This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
// Example 2:

// Input: piles = [3,7,2,3]
// Output: true