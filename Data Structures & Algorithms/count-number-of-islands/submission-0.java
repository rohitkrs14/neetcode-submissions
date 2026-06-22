class Solution {
    class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int count = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    bfs(i, j, grid, vis, n, m);
                }
            }
        }
        return count;
    }

    public void bfs(int row, int col, char[][] grid, int[][] vis, int n, int m) {
        Queue<Pair> que = new LinkedList<>();
        vis[row][col] = 1;
        que.offer(new Pair(row, col));

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!que.isEmpty()) {
            Pair temp = que.poll();
            int r = temp.row;
            int c = temp.col;

            for(int i=0;i<4;i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    if(vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = 1;
                        que.offer(new Pair(nrow, ncol));
                    }
                } 
            }
        }
    }
}
