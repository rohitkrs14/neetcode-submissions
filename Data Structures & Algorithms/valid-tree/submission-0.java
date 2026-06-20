class Solution {
    class Pair {
        int node;
        int parent;
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;
        List<List<Integer>> adj = new ArrayList<>(n);

        for(int i =0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        Queue<Pair> que = new LinkedList<>();

        for(int i =0;i<n;i++) {
            if(vis[i] != 1) {
                if(bfs(i, -1, adj, que, vis) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int src, int parent, List<List<Integer>> adj, Queue<Pair> que, int[] vis) {
        que.offer(new Pair(src, parent));
        vis[src] = 1;
        while(!que.isEmpty()) {
            Pair pair = que.poll();
            for(Integer next:adj.get(pair.node)) {
                if(pair.parent == next) continue;
                if(vis[next] == 1) {
                    return false;
                }
                que.offer(new Pair(next, pair.node));
                vis[next] = 1;
            }
        }
        return true;
    }
}
