class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n+1][m+1];

        int count = 0;

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    bfs(i, j, grid, vis, n, m);
                }
            }
        }
        return count;
    }
    private void bfs(int i, int j, char[][] grid, int[][] vis, int n, int m) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(i, j));
        vis[i][j] = 1;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!que.isEmpty()) {
            Pair pair = que.poll();
            int row = pair.first;
            int col = pair.second;

            for(int k =0;k<4;k++) {
                int nrow = delrow[k] + row;
                int ncol = delcol[k] + col;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    grid[nrow][ncol] = 1;
                    que.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}
