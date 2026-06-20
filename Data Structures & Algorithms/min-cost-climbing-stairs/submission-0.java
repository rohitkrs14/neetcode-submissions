class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(n-1, cost, dp), helper(n-2, cost, dp));
    }
    int helper(int ind, int[] cost, int[] dp) {
        if(ind == 0) return cost[ind];
        if(ind == 1) return cost[ind];

        if(dp[ind] != -1) return dp[ind];
        return dp[ind] = cost[ind] + Math.min(helper(ind-1, cost, dp), helper(ind-2, cost, dp));
    }
}
