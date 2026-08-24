class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String newStr = new String(chArray);
            if(map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                map.put(newStr, new ArrayList<>());
                map.get(newStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
