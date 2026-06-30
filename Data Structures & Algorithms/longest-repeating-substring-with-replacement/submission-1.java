class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for(int right =0;right < s.length();right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) +1);
            maxFrequency = Math.max(maxFrequency, map.get(ch));
            if(right - left + 1  - maxFrequency > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
