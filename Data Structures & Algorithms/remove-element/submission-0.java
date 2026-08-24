class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
            i++;
        }
        return k;
    }
}