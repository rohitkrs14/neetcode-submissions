class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for(int i =0;i<n;i++) {
            if(map.containsKey(nums[i])) {
                return Math.abs(i - map.get(nums[i])) <= k;
            }
            map.put(nums[i], i);

            if(map.size() > k) {
                map.remove(nums[left]);
                left++;
            }
        } 
        return false;
    }
}