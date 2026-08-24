class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String newStr = new String(chArray);
            map.computeIfAbsent(newStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
