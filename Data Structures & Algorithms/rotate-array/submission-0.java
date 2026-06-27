class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0) return;
        int n = nums.length;
        k = k%n;
        helper(nums, 0, n-1);
        helper(nums, 0, k-1);
        helper(nums, k, n-1);
    }

    public void helper(int[] nums, int l, int r) {
        while(l<r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}