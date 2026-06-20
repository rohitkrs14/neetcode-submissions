class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        Queue<Integer> que = new LinkedList<>();
        int count =0;

        for(int i =0;i<n;i++) {
            if(vis[i] != 1) {
                count++;
                bfs(i, adj, que, vis);
            }
        }
        return count;
    }
    public void bfs(int src, List<List<Integer>> adj, Queue<Integer> que, int[] vis) {
        vis[src] =1;
        que.offer(src);
        while(!que.isEmpty()) {
            int node = que.poll();
            for(int next:adj.get(node)) {
                if(vis[next] != 1) {
                    vis[next]= 1;
                    que.offer(next);
                }
            }
        }
    }
}
