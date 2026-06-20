class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        int n = nums.length;
        for(int i =0;i<n;i++) {
            if(i > far) return false;
            far = Math.max(i+nums[i], far);
            if(far >= n-1) return true;
        }
        return false;
    }
}
