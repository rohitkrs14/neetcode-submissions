class Solution {
    class Pair {
        int key;
        int value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0) +1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {

            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int res[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll().key;
        } 
        return res;
    }
}
