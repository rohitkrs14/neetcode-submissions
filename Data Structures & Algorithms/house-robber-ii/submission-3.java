class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int take1 = helper1(n-2, nums, dp);
        Arrays.fill(dp, -1);
        int take2 = helper2(n-1, nums, dp);
        return Math.max(take1, take2);
    }
    int helper1(int ind, int[] nums, int[] dp) {
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int take = nums[ind] + helper1(ind-2, nums, dp);

        int nonTake = Integer.MIN_VALUE;

        nonTake = helper1(ind-1, nums, dp);

        return dp[ind] = Math.max(take, nonTake);
    }
    int helper2(int ind, int[] nums, int[] dp) {
        if(ind == 1) return nums[ind];
        if(ind < 1) return 0;
        if(dp[ind] != -1) return dp[ind];
        int take = nums[ind] + helper2(ind-2, nums, dp);

        int nonTake = Integer.MIN_VALUE;

        nonTake = helper2(ind-1, nums, dp);

        return dp[ind] = Math.max(take, nonTake);
    }
}
