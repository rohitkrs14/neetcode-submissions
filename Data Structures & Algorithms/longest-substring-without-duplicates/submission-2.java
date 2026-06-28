class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s.length() <= 1) return s.length();

        for(int i =0;i<s.length();i++) {
            int max = 0;
            int count =0;
            Set<Character> set = new HashSet<>();
            for(int j =i;j<s.length();j++) {
                if(set.contains(s.charAt(j))) {
                    max = Math.max(max, j-i);
                    break;
                }
                count++;
                set.add(s.charAt(j));
            }
            if(max != 0) {
            maxLen = Math.max(max, maxLen);
            } else {
                maxLen = Math.max(count, maxLen);
            }
        }
        return maxLen;
    }
}
