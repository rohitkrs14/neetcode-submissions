class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left =0;
        int val = nums[0];
        for(int i =1;i<n;i++) {
            if(nums[i] != val) {
                val = nums[i];
                nums[++left] = nums[i];
            }
        }
        return left+1;
    }
}