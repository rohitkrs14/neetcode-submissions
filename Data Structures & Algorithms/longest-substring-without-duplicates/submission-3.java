class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        for(int i =0;i<n;i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch)+1);
            }
            map.put(ch, i);
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
