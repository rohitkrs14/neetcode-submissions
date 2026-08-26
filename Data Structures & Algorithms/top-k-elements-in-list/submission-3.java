class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val: nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        List<List<Integer>> temp = new ArrayList<>();
        int n = nums.length;
        for(int i =0;i<=n;i++) {
            temp.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            temp.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int j = 0;
        for(int i=temp.size()-1;i>=0;i--) {
            if(temp.get(i).size() > 0 && k>0){
                for(int v: temp.get(i)) {
                    res[j++] = v;
                    k--;
                }
            }
        }   
        return res;
    }
}
