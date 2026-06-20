class Solution {

    class Pair {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        int[] distance = new int[n];

        for(int i =0;i<n;i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for(List<Integer> list : edges) {
            int source = list.get(0);
            int dest = list.get(1);
            int dist = list.get(2);
            map.putIfAbsent(source, new ArrayList<>());
            map.get(source).add(new Pair(dist, dest));
        }
        distance[src] = 0;
        bfs(0, src, map, distance);
        for(int i=0;i<n;i++) {
            if(distance[i] == Integer.MAX_VALUE) 
                result.put(i, -1);
            else 
                result.put(i, distance[i]);
        }
        return result;
    }  
    public void bfs(int d, int n, Map<Integer, List<Pair>> map, int[] distance) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(d, n));

        while(!pq.isEmpty()) {
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            
            for(Pair pair : map.getOrDefault(node, new ArrayList<>())) {
                int currDist = pair.distance;
                int currNode = pair.node;

                int newDistance = dist + currDist;
                if(newDistance < distance[currNode]) {
                    distance[currNode] = newDistance;
                    pq.offer(new Pair(newDistance, currNode));
                }
            }
        }

    }
}
