class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int val:nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            if(map.get(val) > n/2) return val;
        }
        return 0;
    }
}