class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length==0) return 0;
        for(int num : nums) {
            set.add(num);
        }
        int maxCount =0;
        for(Integer num : set) {
            if(!set.contains(num-1)) {
                Integer val = num;
                int count = 1;
                while(set.contains(val+1)) {
                    count++;
                    val++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
