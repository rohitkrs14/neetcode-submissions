class Solution {
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public int helper(int ind, int[] dp) {
        if(ind == 0) return 1;
        if(ind == 1) return 1;
        if(dp[ind] != -1) return dp[ind];
        return dp[ind] = helper(ind-1, dp) + helper(ind-2, dp);
    }
}
