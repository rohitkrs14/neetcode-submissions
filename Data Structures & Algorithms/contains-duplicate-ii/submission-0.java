class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        for(int i =0;i<n-1;i++) {
            for(int j =i+1;j<n;j++) {
                if(nums[i] == nums[j] && Math.abs(i-j) <=k) return true;
            }
        }
        return false;
    }
}